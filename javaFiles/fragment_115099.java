public static void main(String[] args) {
    final Scanner myScanner = new Scanner(System.in);
    String sentence;
    System.out.print("Enter a sentence:");
    sentence = myScanner.nextLine();
    // now split by space
    final String[] sentceComp = sentence.split(" ");
    // loop over the words in sentence
    for (int i = 0; i < sentceComp.length; i++) {
        System.out.println("The word \"" + sentceComp[i] + "\" in the input sentence has " + sentceComp[i].length() + " chars");
    }
}