I am not giving you the exact code but you should do it something like this.

Class B{
 A a;


public B(){
initialize();

}


 //I will call this method in class C to use the same instance of class A 
 public A getInstanceOfA() { return a; } 

// this method should not be main
 public void initialize{
   a = new A();
   Thread t = new Thread(a);
   t.start();

   a.setNum(5);
   System.out.println(a.getNum()); //getting output as 5. Okay as Expected. 
  }
 }

 class C{
  A a;
  public static void main(String[] args){

   B b = new B();
   a = b.getInstanceOfA();

   System.out.println(a.getNum()); 
   //Here I'm getting output 0 not 5 why? As Thread created on instance a is 
   //already running, and also I am using the same instance of class A 
   //so I should get the updated value 5, but getting 0. Why it is re-initializing num?

  }
 }