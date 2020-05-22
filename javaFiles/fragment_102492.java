class Derived extends B{
    public Derived(){
        super(); 
        // this is the important bit, by calling super() you call the parent classes
        // constructor, which in this case changes the attribute "flag"
        // by using the constructor of the external class on the class
    }
}

class B {
    boolean flag;
    ExternalClass e;

    public B(){
        e = new ExternalClass(this);
    }

    public void setFlag(boolean value) {
        flag = value;
    }

    public void printFlag() {
        System.out.println(flag);
    }

}

class ExternalClass {

    B b = null;

    public ExternalClass(B b) {
        this.b = b;
        b.setFlag (true);
    }
}