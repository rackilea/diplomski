public static void main(String[] args) {
    String passage = "Well, I'm looking for a regexp in Java that deletes all words shorter than 3 characters.";
    System.out.println(passage);

    passage = passage.replaceAll("\\b[\\w']{1,2}\\b", "");
    passage = passage.replaceAll("\\s{2,}", " ");

    System.out.println(passage);
}