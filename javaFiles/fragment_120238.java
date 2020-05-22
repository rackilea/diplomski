class Quadratic {
    int a;
    int b;
    int c;

    void setQuadratic(int newA, int newB, int newC) {
        a = newA;
        b = newB;
        c = newC;
    }        
}

// ... rest of your code

public static Quadratic sum(Quadratic q1, Quadratic q2){
    Quadratic result = new Quadratic();
    int newA =(q1.a + q2.a);
    int newB =(q1.b + q2.b);
    int newC =(q1.c + q2.c);   
    result.setQuadratic(newA, newB, newC);
    return result; 
}