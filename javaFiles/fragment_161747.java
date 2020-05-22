public class A{        
    public class B extends A {
        B() { }  
    }    

    public class C extends B {
        C() { 
            new A().super();  
        }  
    }    

    public static void main(String args[])  {

    }      
}