class A {  
    public int a=0;
}  

class B extends A {  
    public int a=1;

    public int superClassA() { 
        return super.a; 
    } 
}