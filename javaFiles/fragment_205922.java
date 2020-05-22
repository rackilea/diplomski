public interface BlammyHoot
{
  void hoot(); // this is the call back.
}

public class C implements BlammyHoot
{
  public void hoot()
  {
    // implement the callbe method here.
  }
}

public class B
{
  private List<BlammyHoot> hootList = new LinkedList<BlammyHoot>();

  public void registerBlammyHoot(final BlammyHoot theHoot)
  {
    if (theHoot != null)
    {
      hootList.add(theHoot);
    }
  }

  public void respondToTimerTimeout()
  {
    for (BlammyHoot hootElement : hootList)
    {
      hootElement.hoot();
    }
  }
}