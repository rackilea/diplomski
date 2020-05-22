private static final Object syncObj = new Object();

public void increment()
{
  syncrhonized( syncObj )
  {
   c++;
   System.out.println(c);
  }
}