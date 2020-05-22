class Person implements Comparable<Person>
{
  private int age;
  private String name;
  public Person(String name, int age)
  {
    this.name = name;
    this.age = age;
  }
  @Override
  int compareTo(Person p)
  {
     return p.age - this.age;
  }
}

public class BinarySearch {


    private BinarySearch() { }


   public static <E extends Comparable<E>>int binarySearch(E[] list, E key){
        int lo = 0;
        int hi = list.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < list[mid]) hi = mid - 1;
            else if (key > list[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
  }

public static void main(String args[])
{
  Person personArray[] = new Person[10];
  Person toBeFound = new Person("Joe", 5);
  // fill the array here
  int x = BinarySearch.binarySearch(personArray, toBeFound);
  if(x == -1) System.out.println("Not found");
  else System.out.println(x);
}