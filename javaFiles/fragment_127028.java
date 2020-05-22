public static void main(String[] args) {
  removeDuplicates("a");
  System.out.println();
  removeDuplicates("aabbcdddefghhii");
  System.out.println();
  removeDuplicates("aabbcdefa");
}

public static void removeDuplicates(String a) {
   removeDuplicatesHelper(a, 0);
}

public static void removeDuplicatesHelper(String a, int b) {
  if (b == a.length() - 1) {
    System.out.print(a.charAt(b));
  } else if (a.charAt(b) == a.charAt(b+1)) {
    b++;
    removeDuplicatesHelper(a, b);
  } else {
    System.out.print(a.charAt(b));
    b++;
    removeDuplicatesHelper(a, b);
  }
}