public Object getPrimitiveValue(String type, String value) {
    if(type.equals("int")) {
        return new Integer(Integer.parseInt(value));
    }
    else if(type.equals("double")) {
        return new Double(Double.parseDouble(value));
    }
    //etc.
}