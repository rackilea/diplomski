public class Main {
  public static void main( String[] args ) {
  ...
    ClassOuter outerObj = new ClassOuter();    
    ClassOuter.DataInner value = outerObj.new DataInner();
    outerObj.setInner (value);
  }
}

class ClassOuter{

  public static class DataInner{
    public int x;
  }
  ...
  private DataInner inner = null;
  public void setInner (DataInner inner) {
      this.inner = inner;
  }
  protected void getNo()
  {
      inner.x=Integer.parseInt("493"); 
  }
}