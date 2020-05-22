System.out.println("Enter words, type (stop or exit) to stop:");
System.out.println();

Scanner keyboard = new Scanner(System.in);
String word = keyboard.nextLine();
int wordcount = 0;

while(!(word.equalsIgnoreCase("exit") || !word.equalsIgnoreCase("stop"))) {
   word = keyboard.nextLine();
   wordcount++;   
}

System.out.println("you enetered " + wordcount + " word(s).");