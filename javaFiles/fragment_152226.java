import java.util.*;

public class SortedLinkedListDemo {

public static void main (String [] args) {
    List<String> list = new LinkedList<String> ();
    list.add ("Dusty");
    list.add ("Gordon");
    list.add ("Mayer");
    list.add ("Popovic");
    list.add ("Zechariah");

    list.add (getSortedIndex ("Nyugen", list), "Nyugen");

    System.out.println ("List: "+list);
}

private static int getSortedIndex (String name, List<String> list) {
    for (int i=0; i < list.size(); i++) {
        if (name.compareTo(list.get(i)) < 0) {
            return i;
        }
    }       
    // name should be inserted at end.
    return list.size();
}