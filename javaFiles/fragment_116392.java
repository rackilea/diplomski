public class HalfedgeComparator
        implements Comparator<Halfedge>;
{

  Object param1 = null;

  public HalfedgeComparator (Object param1) {
    this.param1= param1;
  }

  public int compare(Halfedge item1, Halfedge item2)
  {
    return ...;
     //your logic here where you can use the param1 passed in the constructor
  }
}