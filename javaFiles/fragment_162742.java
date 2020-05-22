String original, reverse = "";
  Scanner in = new Scanner(System.in);

  System.out.println("Enter a string to check if it is a palindrome");
  original = in.nextLine();
  original = original.replaceAll("[^a-zA-Z]","").toLowerCase();