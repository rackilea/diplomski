class Compress {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String inputString = scanner.nextLine();
    scanner.close();
    System.out.println("Compressed Input: " + compressInput(inputString));
  }

  private static String compressInput(String str) {
    if(str.isEmpty())
        return "";
    if(str.length() == 1)
        return str + "1";

    StringBuilder result = new StringBuilder();
    int cmpt = 1;
    for (int i = 1; i < str.length(); i++) {
      if(str.charAt(i - 1) == str.charAt(i))
          cmpt++;
      else {
          result.append(str.charAt(i-1));
          result.append(cmpt);
          cmpt=1;
      }
    } 
    result.append(str.charAt(str.length()-1));
    result.append(cmpt);
    return result.toString();
  }

}