public class Test{

  private Test() {
    //Prevent construction by other classes, forcing the 
    // use of the factory
  }

  public static Test create(){
    return new Test();
  }

  public static void main (String[] args){
    Test ob = Test.create();
  }
}