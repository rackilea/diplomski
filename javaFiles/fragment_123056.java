class SuperClass {
    static void a() { System.out.println("SuperClass.a()"); }
    static void b() { System.out.println("SuperClass.b()"); }
    void testSuper() { // Call from "inside" SuperClass
        a(); // calls SuperClass.a()
        b(); // calls SuperClass.b()
    }
}
class SubClass extends SuperClass {
    static void b() { System.out.println("SubClass.b()"); }
    static void c() { System.out.println("SubClass.c()"); }
    void testSub() { // Call from "inside" SubClass
        a();   // calls SuperClass.a().
        b();   // calls SubClass.b().
        c();   // calls SubClass.c()
    }
}
class Test {
    void testSuper() { // Call SuperClass from "outside"
        SuperClass.a(); // calls SuperClass.a()
        SuperClass.b(); // calls SuperClass.b()
    }
    void testSub() { // Call SubClass from "outside"
        SubClass.a(); // calls SuperClass.a()
                      // IDE warning: The static method a() from the type SuperClass should be accessed directly
        SubClass.b(); // calls SubClass.b()
        SubClass.c(); // calls SubClass.c()
    }
}