public class MyNameStrategy extends PropertyNamingStrategy {
    @Override
    public String nameForField(MapperConfig config, AnnotatedField field, String defaultName) {
        return convertFieldName(field.getName());
    }

    @Override
    public String nameForGetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return convertMethodName(method.getName(),defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig config, AnnotatedMethod method, String defaultName) {
        return convertMethodName(method.getName(),defaultName); 
    }

    public String convertMethodName(String methodName,String defaultName) {
        if(methodName.compareTo("isEmpty")==0 || methodName.compareTo("isNaN")==0 || methodName.compareTo("isInfinite")==0) {
            return defaultName;
        }
        return convertFieldName(methodName.substring(3));
    }

    public String convertFieldName(String fieldName) {
        char[] arr=fieldName.toCharArray();
        if(arr.length!=0) {
            if(Character.isUpperCase(arr[0])){
                char lower = Character.toLowerCase(arr[0]);
                arr[0] = lower;
            }
        }
        return new StringBuilder().append(arr).toString();
    }
}