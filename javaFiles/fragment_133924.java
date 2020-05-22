public static void main (String args[]) {
  Scanner scan1 = new Scanner("hello 1 2 3.5 there");
  while (scan1.hasNext()) {
    if (scan1.hasNextInt()) {
       // do something with int
       int i = scan1.nextInt();
       System.out.println(i);
    } else {
       // move past non-int token
       scan1.next();
    }
  }
}