public static void main(String[] args) {
    ArrayList<String> badWords = new ArrayList<String>();
    badWords.add("test");
    badWords.add("BadTest");
    badWords.add("\\$\\$");
    String test = "This is a TeSt and a $$ with Badtest.";
    for(int i = 0; i < badWords.size(); i++) {
            test = test.replaceAll("(?i)" + badWords.get(i), "****");
    }
    test = test.replaceAll("\\w*\\*{4}", "****");
    System.out.println(test);
}