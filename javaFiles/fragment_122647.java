public static void test(String str) {
    String[] words = str.split("\\s+");
    for(String word: words) {
        System.out.println(word);
        //Here decide what you want to do with each word
    }
}