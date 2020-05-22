public class Child1 extends Super1 {
    private int l;
    public Child1(Super1 s){
        super(s);
    }
    public Child1(){
        this.l=20;
    }
}

public class Super1 {
    private int k;
    public Super1(){

    }
    public Super1(Super1 s){
        k=s.k;
    }
}