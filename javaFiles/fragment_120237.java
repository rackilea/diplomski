public static Quadratic sum(Quadratic q1, Quadratic q2){
    Quadratic result = new Quadratic(); 
    result.a =(q1.a + q2.a);
    result.b =(q1.b + q2.b);
    result.c =(q1.c + q2.c);   
    return result;
}