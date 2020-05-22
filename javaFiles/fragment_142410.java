@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

    private final ObjectMapper sweMapper;
    private final ObjectMapper norMapper;
    private final ObjectMapper defaultMapper;

    @Context
    private UriInfo uriInfo;

    public ObjectMapperContextResolver() {
        defaultMapper = new ObjectMapper();

        sweMapper = new ObjectMapper();
        SimpleModule sweModule = new SimpleModule("SweModule", new Version(1,0,0,null));
        sweModule.addDeserializer(Date.class, new JsonDateDeserializer(sweFormat));
        sweModule.addSerializer(Date.class, new JsonDateSerializer(sweFormat));
        sweMapper.registerModule(sweModule);

        norMapper = new ObjectMapper();
        SimpleModule norModule = new SimpleModule("NorModule", new Version(1,0,0,null));
        norModule.addDeserializer(Date.class, new JsonDateDeserializer(norFormat));
        norModule.addSerializer(Date.class, new JsonDateSerializer(norFormat));
        norMapper.registerModule(norModule);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        String country = uriInfo.getPathParameters().getFirst("country");
        if (country == null) {
            return defaultMapper;
        }

        switch (country) {
            case "se": return sweMapper;
            case "no": return norMapper;
            default: return defaultMapper;
        }
    }  
}