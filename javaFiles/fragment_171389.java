class A {
    final int x;
    A() { 
        x = 1; 
    } 

    int f() { 
        return d(this,this); 
    } 

    int d(A a1, A a2) { 
        int i = a1.x; 
        g(a1); 
        int j = a2.x; 
        return j - i; 
    }

    static void g(A a) { 
        // uses reflection to change a.x to 2 
    } 
}