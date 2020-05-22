public class A{
     private int val;

     protected void setVal(int i){
        val = i;
     }

     public int getVal(){
        return val;
     }
}

public class B extends A{
    public void test(){
        this.setVal(4);
    }
}