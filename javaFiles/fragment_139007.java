if (input.hasNextInt()) {
  System.out.println("You Entered A Number " + input.nextInt());
} else if (input.hasNext("\\w")) {
  System.out.println("You Entered An Alphabet " + input.next());
} else {
  System.out.println("You Enter A Special Character");
}