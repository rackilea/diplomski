static String toString(MyClass obj) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    XMLEncoder e = new XMLEncoder(baos);
    e.writeObject(obj);
    e.close();
    return new String(baos.toByteArray());
}

static MyClass fromString(String str) {
    XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(str.getBytes()));
    MyClass obj = (MyClass) d.readObject();
    d.close();
    return obj;
}
public static void main(String[] args) {

    MyClass obj = new MyClass();
    obj.setProp("propval");
    String s = toString(obj);
    System.out.println("s = " + s);
    MyClass obj2 = fromString(s);
    System.out.println("obj2.getProp() = " + obj2.getProp());
}