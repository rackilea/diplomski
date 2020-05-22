public static String[] printLatinWords()
{
    System.out.println("Enter a Sentence: ");
      Scanner scanner = new Scanner(System.in);
      str = scanner.nextLine();
      words = str.split(" ");
      //System.out.println(words);
      return words;
}