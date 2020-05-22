Scanner in = new Scanner(System.in);
  String userWords = "";
  String currentWord = "";
  // now we print a prompt for user
  System.out.println("Enter words to build a sentence");  
  // here is the reading loop
  do {
      // now we read next line from user
      currentWord = in.nextLine();
      // now we add the user input to the userWords with " "
      userWords += currentWord +" ";
      // we end the loop when the currentWord will be empty
  } while (!(currentWord.trim().isEmpty())); 
  // now we print all the words
  System.out.println(userWords);