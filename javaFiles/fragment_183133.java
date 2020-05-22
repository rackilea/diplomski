static boolean checkDeepNull(Object root, String... attributes) throws NoSuchFieldException, IllegalAccessException {
    Object currentAttribute = root;
    for(int attr = 0; currentAttribute != null && attr < attributes.length; attr++){
        Field nextField = currentAttribute.getClass().getField(attributes[attr]);
        Object nextAttribute = nextField.get(current);
        if(nextAttribute == null) return false;
        currentAttribute = nextAttribute;
    }
    return true;
}