class Parent1 {
    private String name;
    private int id;
    public static int count=0;

    public Parent1(String name, int id) {
        this(name, id, true);
    } 

    protected Parent1(String name, int id, boolean incrementCount){
        this.name=name;
        this.id=id;
        if( incrementCount )
            count++;
    }
}

class Child1 extends Parent1{
    private int age;

    public Child1(String name, int id, int age){
        super(name, id, false);
        this.age=age;
    }
}

//....

Parent1 par= new Parent1("aa",5);
Parent1 par2=new Parent1("bb",10);