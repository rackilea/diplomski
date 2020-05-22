public static Quadratic sum(Quadratic q1, Quadratic q2) {
    int newA =(q1.a + q2.a);
    int newB =(q1.b + q2.b);
    int newC =(q1.c + q2.c);   
    return new Quadratic(newA, newB, newC); 
}