class Average {
  public static void main(String[] args) {
    String word = args[0]; // let us suppose you get the word this way
    float sum = 0;
    for(int i = 0; i < word.length(); i += 1) {
      sum += word.charAt(i);
    }

    System.out.println("Sum is " + sum + " and average is " + Math.round(sum/word.length()) + "(" + sum/word.length() + ")");
  }
}