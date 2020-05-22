public class XYZ {
  static void printAll(ArrayList myList)
  {
    Iterator it = myList.iterator();
    Object temp;
    while(it.hasNext() )
    {
      temp = it.next();
      System.out.println( temp );
    }
    return;
  }

  public static void main(String...args){

    List<String> myList= new ArrayList<String> ( );
    myList.add("Hello");
    myList.add("World");
    printAll(myList);//passing myList to printAll
  }
}