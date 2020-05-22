private static int sum = 0;

public static int convert(Node head,int i) {

  if(head.next != null) {
    i = convert(head.next, i);
  }
  sum += head.data * (int)Math.pow(2,i);
  return i+1;
 }

// Call this function as below:

convert(head,0);