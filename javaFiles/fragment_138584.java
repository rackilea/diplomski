// prompt
System.out.println("Type your text...");
// scanner initialization
Scanner sc = new Scanner(System.in); 
// getting next line by user, then getting the length and printing it
System.out.println(sc.nextLine().length());
// once we're done with the Scanner...
sc.close();