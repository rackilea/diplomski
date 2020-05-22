public class App {

public static void main(String[] args) {
    // TODO Auto-generated method stub

    List<String> people= new ArrayList<String>();
    people.add("Sam");
    people.add("Bob");
    people.add("Andrew");
    people.add("Michel");
    people.add("Abe");
    people.add("John");

    Comparator<String> mycom= new NaturalOrderString();

    Collections.sort(people); // this will sort the people array list in natural order

    Collections.sort(people,Comparator.reverseOrder()); // Here's your desired method it will reverse the natural order as documentation.

     }
  }