public boolean alwaysFalse(){
        float a=Float.MIN_VALUE;
        float b=Float.MAX_VALUE;
        float c = a / b;
        return a == c * b;
}