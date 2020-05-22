Scanner input = new Scanner (System.in);
LinkedList<Integer> booksList = new LinkedList<>();
System.out.printf ("Give: ");       

while (input.hasNextInt ()) {            
    booksList.add (input.nextInt ());
}
bookList.remove ();
bookList.remove ();