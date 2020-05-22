Scanner scn = new Scanner(System.in); //imports scanner reader

System.out.println("\nplease enter a code to decrypt");
String encryptedText = scn.nextLine(); //assigns the word entered by user to varible userinput
System.out.println("please enter the pattern for the decryption");
int pattern = scn.nextInt(); //changes the string value to integer value
scn.nextLine();

for (int x=0; x<encryptedText.length(); x+=(pattern+1))
    System.out.print(encryptedText.charAt(x));