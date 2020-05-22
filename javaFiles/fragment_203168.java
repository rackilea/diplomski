class A {
    // methods to be looked up
    // a static method
    static void a() {};
    // non-static method
    void b() {};


    static void c() {
         // valid reference to another static method
         a();        
    }

    static void d() {
         // This would fail to compile as d is a static method 
         // but b is a non-static
         b();        
    }

    // non-static method would compile fine
    void e() {
       a(); // non-static method can find a static method 
       b(); // non-static method can find another non-static method
    }

}