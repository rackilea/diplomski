public class Value {
    void method1()
    {
        int demo=10;
        System.out.println("methd 1"+demo);
    }
    void method2()
    {
        System.out.println("method 2");
        this.method1();
    }

    public static void main(String[] args) {
        Value obj = new Value ();
        obj.method1();
        obj.method2();
    }
}