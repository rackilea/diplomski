public class RoleBasedPropertyFilter extends SimpleBeanPropertyFilter {

    private String allowedRole;

    public RoleBasedPropertyFilter(String allowedRole) {
        this.allowedRole = allowedRole;
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen,
                                 SerializerProvider provider, 
                                 PropertyWriter writer) throws Exception {

        PermitAll permitAll = writer.getAnnotation(PermitAll.class);
        if (permitAll != null) {
            serializeAsField(pojo, jgen, provider, writer);
            return;
        }

        DenyAll denyAll = writer.getAnnotation(DenyAll.class);
        if (denyAll != null) {
            writer.serializeAsOmittedField(pojo, jgen, provider);
            return;
        }

        RolesAllowed rolesAllowed = writer.getAnnotation(RolesAllowed.class);
        if (rolesAllowed != null) {
            if (!Arrays.asList(rolesAllowed.value()).contains(allowedRole)) {
                writer.serializeAsOmittedField(pojo, jgen, provider);
                return;
            }
        }

        // If no annotation is provided, the property will be serialized
        writer.serializeAsField(pojo, jgen, provider);
    }
}