class Person{  
public int a;
public void finalize(){
    //System.out.println("finalize called"+this.hashCode());
    System.out.println("finalize called"+this.a);
}  
public static void main(String[] args){  
    Person f1=new Person();  
    f1.a=10;
    Person f2=new Person();  
    f1=null;  
    f2=null;  
    System.gc();  
}}