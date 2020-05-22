@CustomParameterized
public class Example {

  private String arg;

  public Example(String arg){
    this.arg = arg;
  }

  @org.junit.Test
  public void test(){
    assertEquals("a",arg);
  }

}