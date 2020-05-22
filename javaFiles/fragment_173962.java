public class Foo{
  private static interface A{ 
    void aStuff();
  }

  private static class B{ 
    public void doBStuff(){ 
        System.out.println("B stuff");
    } 
  }

  private static class AB extends B implements A{
    public void aStuff(){
        System.out.println("A stuff");
    }
  }

  public static void main(String[] args) {
    Foo foo = new Foo();
    foo.example(new AB());
  }

  // method "example" already given
}