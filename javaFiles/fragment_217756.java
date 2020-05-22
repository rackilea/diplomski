class A {

void override()
{
    System.out.println("Inside A");
}

}

 class B extends A
{
     void override()
     {
        System.out.println("Inside B");
     }  

}

 class C extends A
 {
     void override()
     {
         System.out.println("Inside C");
     }
 }

 class Main
 {
     public static void main(String args[])
     {
         A a =new A();

         a.override();
         a=new B();

         a.override();

         a=new C();

         a.override();
     }
 }