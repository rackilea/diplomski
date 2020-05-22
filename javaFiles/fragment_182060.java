public class GenericsTest<T extends Animal>
{
  private List<T> myList;

  public static void main(String args[])
  {
    new GenericsTest<Dog>(new ArrayList<Dog>());
  }

  public GenericsTest(List<T> list)
  {
    myList = list;
  }

  public void add(T a)
  {
    myList.add(a);
  }
}