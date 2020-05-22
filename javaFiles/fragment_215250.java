public class AdapterDemo extends Applet
{

  class MyMouseAdapter extends MouseAdapter{
     [...]
  }

  public void init()
  {
      addMouseListener(new MyMouseAdapter());
  }
}