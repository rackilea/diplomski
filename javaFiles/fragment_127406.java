public class Driver {

      public static void main(String[] args) {
          LinkedList ll = new LinkedList();
          ll.add(7);
          ll.add(5);
          ll.add(13);
          ll.add(27);
          ll.add(2);
          ll.printList();
          ll.removeAtIndex(3);
          ll.printList();
      }
}