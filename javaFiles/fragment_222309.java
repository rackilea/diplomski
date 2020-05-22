class A {
    A() {
        f();
    }
    protected void f() {
    }
}

class B {
    String s;
    String t = null;
    String u = "U";
    B() {
        // 0. B is not created, all fields are defaulted: 0, null, false, 0.0.
        //    s == null, t == null, u == null (!)
        // 1. super() is called
        //    s == "S",  t == "T",  u == null (!)
        // 2. all field initialisations are done: for t and u.
        //    s == "S",  t == null, u == "U" 
        // 3. the rest of the constructor code is done.
        System.out.printf("B.B: s %s; t %s; u %s%n", s, t, u);
    }

    @Override
    protected void f() {
        System.out.printf("B.f: s %s; t %s; u %s%n", s, t, u);
        // When called from A(): s, t and u (!) are null.
        s = "S";
        t = "T";
    }
}