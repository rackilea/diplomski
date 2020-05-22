public static void main(String[] args) {
    String word = "TECHNOLOGY"; // what the user must guess
    StringBuilder gletters = new StringBuilder("GOTCHA"); // letters guessed
    String mainword = word.replaceAll("[^" + gletters + "]", "_");
    System.out.println(mainword);
}