public static <T extends Number> double power(T x, int y){
    /* I don't feel like calling this in a loop */ 
    double dx = x.doubleValue();
    double result = 1;

    for(int i=0; i<y; i++){
        result *= dx;
    }
    return result;
}