Class clazz = myObject.getClass();
Method getId = clazz.getMethod("getId");
Object result = m.invoke(myObject);
if (((String)result).length() > MAX_LENGTH) {
    throw new Exception();
}