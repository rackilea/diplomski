TypeName TYPE_LIST = ClassName.get(List.class);
boolean isList = isFromType(type, TYPE_LIST)

public static boolean isFromType(TypeName requestType, TypeName expectedType) {
    if(requestType instanceof ParameterizedTypeName) {
        TypeName typeName = ((ParameterizedTypeName) requestType).rawType;
        return (typeName.equals(expectedType));
    }

    return false;
}