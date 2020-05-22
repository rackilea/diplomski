public class DataNamingStrategy extends PropertyNamingStrategy{

    // used by other classes (this will be default field name that should be changed)
    public static final String DATA_FIELD = "variable:data";
    private String fieldName;

    public DataNamingStrategy(String fieldName) {
        this.fieldName = fieldName;
    }

    // use this to change field name (format "variable":"value") not needed in my case
    @Override
    public String nameForField(MapperConfig<?> config, AnnotatedField field,
            String defaultName) {
        return (defaultName.equals(DATA_FIELD))?
            fieldName :
            super.nameForField(config, field, defaultName);
    }

    // use this to change setter method field name (JSON -> Object with format "variable":{})
    @Override
    public String nameForSetterMethod(MapperConfig<?> config,
            AnnotatedMethod method, String defaultName) {
        return (defaultName.equals(DATA_FIELD))?
            fieldName :
            super.nameForGetterMethod(config, method, defaultName);
    }

    // use this to change getter method field name (Object -> JSON with format "variable":{})
    // should be same as nameForSetterMethod
    @Override
    public String nameForGetterMethod(MapperConfig<?> config,
            AnnotatedMethod method, String defaultName) {
        return nameForSetterMethod(config, method, defaultName);
    }
}