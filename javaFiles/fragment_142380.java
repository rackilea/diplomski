public class MappingPropertyNamingStrategy extends PropertyNamingStrategy {

    Map<String, String> nameMap = new HashMap<String, String>();

    public void setMap(Map<String, String> map) {
        nameMap = map;
    }

    @Override
    public String nameForGetterMethod(MapperConfig<?> cfg,
                                      AnnotatedMethod method,
                                      String defaultName) {
        return mapName(defaultName);
    }
    @Override
    public String nameForSetterMethod(MapperConfig<?> cfg,
                                      AnnotatedMethod method,
                                      String defaultName) {
        return mapName(defaultName);
    }
    @Override
    public String nameForField(MapperConfig<?> cfg,
                               AnnotatedField field,
                               String defaultName) {
        return mapName(defaultName);
    }

    protected String mapName(String name) {
        if (nameMap.containsKey(name)) {
            return nameMap.get(name);
        } else {
            return name;
        }
    }
}