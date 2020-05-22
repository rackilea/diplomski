class ParentClass {
    protected int a;
    protected Runnable act;
    ParentClass() {
        act = new Runnable() {
            void run() {
                //codes
            }
        }
    }
}

class OuterClass extends ParentClass {
    OuterClass() {
        super();
        super.act = new RunnableClass (a);
    }
}

class RunnableClass implements Runnable {
    private int a;
    public RunnableClass(int a) {
        this.a = a;
    }

    public void run() { //--- the code here
    }

}