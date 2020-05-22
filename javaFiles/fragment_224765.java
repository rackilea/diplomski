public static String arrayToCode(Object[]  arr, String arrName) {
    String arrayTypeText = getArrayType(arr);
    sb.append(arrayTypeText + " " + arrName + ...);
    //...
}


private String getArrayType(Object[] arr) {
    Class<?> clazz = arr.getClass();
    if ( clazz == Double[].class ) {
        return "Double[]";
    } else if (...) {
    }
}