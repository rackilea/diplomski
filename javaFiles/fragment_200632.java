String key, type, value; //from xml;
ObjectWrapper object;
if(type.contains("String")) {
    object = new ObjectWrapper<String>(value);
}
else if(type.contains("Double")) {
    object = new ObjectWrapper<Double>(Double.parseDouble(value));
}

xmlObject.add(key, object);