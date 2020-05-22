public class A{
    static{ 
       // 1
    }
    int x = 30; // 3
    public  A(){
       //4
    }
}

public class B extends A{
    static{
        //2
    }
    private int s = 60; //5
    public B(){
         //6
    }
}

public class Test {
    public static void main(String[] args){
       new B();
    }
}