public class Test{

public ArrayList<Integer> myNumbers()    {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    numbers.add(5);
    numbers.add(11);
    numbers.add(3);
    return(numbers);
 }
}


public class T{


public static void main(String[] args){

   Test t = new Test();
   ArrayList<Integer> arr = t.myNumbers();        // You can catch the returned integer arraylist into an arraylist.
 }


}