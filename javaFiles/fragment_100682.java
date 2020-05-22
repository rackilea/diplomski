class Paint {
}

class Canvas {
}

abstract class A{

  public A()
  {
    System.out.println("A.<init>() entered");
    init();
    System.out.println("A.<init>() exit");
  }

  public void draw(Canvas canvas)
  {
    //some code....
   postDraw(canvas);
  }

  abstract public void postDraw(Canvas canvas);
  abstract public void init();
}


class B extends A{

    private volatile Paint  debugPaint=null;   //this assignment happens in the default B() constructor

    @Override
    public void init()
    {
        System.out.println("B.init() entered");
        debugPaint=new Paint();
        System.out.println("B.init() exit");
    }


    @Override
    public void postDraw(Canvas canvas)
    {
       System.out.println("debugPaint=" + debugPaint);
    }
}

public class Foobar {
    public static void main(String[] args) {
        B b = new B();
        b.draw(new Canvas());
    }
}