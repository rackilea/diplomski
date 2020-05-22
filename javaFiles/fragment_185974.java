static Method[] methods = new Method[10];

public static void method1() {
    System.out.println("method-1");
}

public static void method2() {
    System.out.println("method-2");
}

public static void main(String[] args) throws Exception {
    methods[0] = Test1.class.getDeclaredMethod("method1");
    methods[1] = Test1.class.getDeclaredMethod("method2");
    methods[1].invoke(null);
}