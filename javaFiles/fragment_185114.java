Scanner scanner = new Scanner(System.in);

System.out.println("Define term1.");
String term1 = scanner.nextLine();
System.out.println("Define term2.");
String term2 = scanner.nextLine();

System.out.println("To lexicographically compare terms, choose 1");
System.out.println("To append term2 to term1, choose 2");
System.out.println("To determine if term1 ends with term2, choose 3");
System.out.println("To determine if term1 starts with term2, choose 4");
System.out.println("To return the index of the first occurrence of term2 in term1, choose 5");

while (true) {
  try {
    code = Integer.parseInt(scanner.nextLine());
    break;
  } catch (NumberFormatException e) {
    System.out.println("Please give an integer to proceed.");
  }
}

scanner.close();