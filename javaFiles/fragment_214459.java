public coloredblock (int n,String c){
    super(n); //first line
    if (n<0)
        throw new IllegalArgumentException("n < 0!");
    if (c.lenght() > 10)
        throw new IllegalArgumentException("more of 10!");
    color=c;    
}