imort java.util.*;

class MyList implements Iterable<User> {
   private LinkedList<User> list; 

   ... // All of your methods

   // And now the method that allows 'for each' loops
   public Iterator<User> iterator() { return list.iterator(); }
}