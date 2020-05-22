public static void main(String[] args) throws Exception {

    String word1 = "run";
    String word2 = "sofa";
    String word3 = "computer";

    System.out.println(lastLetters (word1, word2, word3));

}

private static String lastLetters(String word1, String word2,
        String word3) {

    return (word1.substring(word1.length() -1) + 
            word2.substring(word2.length() -1) + 
            word3.substring(word3.length() -1)).toUpperCase();
}