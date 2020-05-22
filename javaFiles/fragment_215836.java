private T GetValueFromDB<T>(String colName, Class<T> returnType) {

    if(returnType.equals(Boolean.class)) {
        return (T)(dbData.getInt(colName) == 1);
    } else if(returnType.equals(Int32.class)) {
        // and so on
    }
}