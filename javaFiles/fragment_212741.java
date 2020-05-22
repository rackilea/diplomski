public void invoker(){
    int x = 20;
    int increment = 30;
    x = getIncrementedValue(x,increment);
}
public int getIncrementedValue(int x, int inc){
     return x+inc;
}