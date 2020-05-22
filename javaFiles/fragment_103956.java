public class MyClass{
  protected Context mContext;
  public MyClass(Context c)
  {
    mContext = c;
  }
  public void doSomething()
  {
    mContext.openFileInput(...)
  }
}