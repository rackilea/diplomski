class A  {
 void f1() {  //this holds address of object of B     
   System.out.println("A f1");
 }
 void f2() {
   System.out.println("A f2");
 }
}//A


class B extends A {

 void f3() {   //new method     
   System.out.println("B f3");
 }

 void f2() { //this holds address of object of B     
   System.out.println("B f2 starts");
   f3(); //this.f3()
   System.out.println("B f2 ends ");

 } }  //B


class TypeCmptbl {
   public static void main(String args[]) {
      A ref; //reference of A
      ref = new B();//Object of B

      //ref.inherited()  allowed
      ref.f1();

      //ref.overridden() allowed
      ref.f2();

     //ref.newMembersOfChild() not allowed
    //ref.f3();

  }//main
}