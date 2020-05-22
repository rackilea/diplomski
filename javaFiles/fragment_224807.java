public class Test {
    public static void main(String[] args) {
        I a = Factory.createInstance(Instance.A);
        I b = Factory.createInstance(Instance.B);

        a.createMyXML();
        b.createMyXML();
    }
}