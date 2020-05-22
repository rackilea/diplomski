class Foo{

    public static void main(String[] args){
       Bar myInstance = new Bar();
       myInstance.M1(); 

    }
 }

class Bar{

   public M1() {
   // do something
    System.out.println(“Hey! Someone called me! I’m here!”)
    M2();
   }

    public M2() {
    System.out.println(“Hey! Someone called me! I’m here!”)
}