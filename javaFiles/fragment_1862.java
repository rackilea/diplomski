// To find length of list
public int length(Node head) {
      int count = 0;
      while(head != null) {
         count++;
         head = head.next;
      }
      return count;
   }

public static int convertWhenLengthIsKnown(Node head, int len) {
      int sum = 0;
      if(head.next != null) {
         sum = convertWhenLengthIsKnown(head.next, len-1);
      }
      return sum + head.data * (int)Math.pow(2,len);
   }


   // Call this function as below:

convertWhenLengthIsKnown(head, length(head)-1);