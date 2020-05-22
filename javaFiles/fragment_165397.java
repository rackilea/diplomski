public static void main(String[] args) {
    List<String> words = new ArrayList<>();
    String string = "[\"abc\",\"def\",\"ghi\",\"jkl\",\"mno\",\"pqr\",\"stu\",\"vwx\",\"yz\"]";

    String withoutBrackets = string.replaceAll("[\\[\\](){}]", ""); // Remove all the brackets
    for (String word : withoutBrackets.split(",")) {
        String singleWord = word.replaceAll("\"", "");
        words.add(singleWord);
    }

    System.out.println(words);
}