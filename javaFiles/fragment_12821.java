import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

...

List<String> myList = new LinkedList<String>();

myList.add("A");
myList.add("B");
myList.add("C");

...

ListIterator<String> it = myList.listIterator();

if (it.hasNext()) {
    String s1 = it.next();
    System.out.println(s1);
}