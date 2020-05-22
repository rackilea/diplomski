class Base implements Serializable { 
    String a;
    Base(String a) { this.a = a; }
}
class Access extends Base { 
    String b;
    Base(String a, String b) { super(a); this.b = b; }
}
class Test {
    public static void main(String[] args) {
        Access access = new Access("string1", "string2");
        // Serialization  
        ObjectOutputStream out = new ObjectOutputStream(...);
        out.writeObject(access);
        // Deserialization 
        ObjectInputStream in = new ObjectInputStream(...);
        Base base = (Base) in.readObject();
        System.out.println("Base.a = " + base.a); // ok, prints "string1"
        // System.out.println("Access.b = " + base.b); // -> compilation error -- this is not an Access object; "string2" has not been deserialized.
    }
}