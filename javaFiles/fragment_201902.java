public class CustomMapper extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Female.class, Male.class).fields("contacts", "contacts", FieldsMappingOptions.hintB(Contact.class));
    }
}