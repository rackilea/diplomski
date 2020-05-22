public class Main{

  public static void main(String[] args){
     new Main();
  }

  Main(){
     new SuperClass().method();
     new SuperClass().method(101010);
     new Subclass().method();
     new Subclass().method(595959);
  }

  class SuperClass{

     SuperClass(){
        System.out.println(this.getClass().getSimpleName());
     }

     public void method(){
        System.out.println("method() from SuperClass -> Calling method(int x)");
        method(0);
     }
     public void method(int x){
        System.out.print("method() from SuperClass " + x + "\n\n");
     }
  }
  class Subclass extends SuperClass{
     @Override
     public void method(int x){
        System.out.print("method() from SubClass " + x + "\n\n");
     }
  }

}