Object getFieldValue(String path) throws Exception {
    int lastDot = path.lastIndexOf(".");
    String className = path.substring(0, lastDot);
    String fieldName = path.substring(lastDot + 1);
    Class myClass = Class.forName(className);
    Field myField = myClass.getDeclaredField(fieldName);
    return myField.get(null);
}