import java.util.Iterator;
import java.util.Vector;

class HisIterator {
   public static void main(String[] args) {
      Vector<Integer> v = new Vector<Integer>();

      v.addElement(new Integer(10));
      v.addElement(new Integer(20));
      v.addElement(new Integer(30));

      Iterator<Integer> i = v.iterator();
      while (i.hasNext()) {
         System.out.println(i.next());
      }
      try {
         v.remove(new Integer(10));
      } catch (Exception e) {
         e.printStackTrace();
      }
      System.out.println();
      i = v.iterator();
      while (i.hasNext()) {
         System.out.println(i.next());
      }

   }
}