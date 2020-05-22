public void myScanner () {
     Scanner scan = new Scanner(System.in); //Creates a new scanner
     System.out.println("Who is on the 5 dollar bill?"); //Asks question
     String input = scan.nextLine(); //Waits for input
     if (input.equalsIgnoreCase("Lincoln")) { //If the input is Lincoln (or any case variant of Lincoln)
          System.out.println("Correct!");
     }
     else { //If the input is anything else
          System.out.println("Incorrect!");
     }
}