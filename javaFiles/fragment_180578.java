class B extends A{
    public B(String x){
        super(x);  // this constructs the parent class
        System.out.println("B constructor Called "+x);
    }
}