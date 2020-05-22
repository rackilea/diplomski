File file = new File("fileName.txt");
Scanner input = new Scanner(file);
while (input.hasNextLine()) {
   String line = input.nextLine(); //<------This is a String representation of a line 
   System.out.println(line); //prints line
   //Do your splitting here of lines containing more than 1 word
   //Store your Strings here accordingly
   //----> Go on to nextLine
}