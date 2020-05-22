//public static Map<String, Integer> sortWords(BufferedReader in) throws IOException{
//    String line = "";
//    Map<String, Integer> wordsCount = new HashMap<>();
//
//    while((line=in.readLine())!=null) {
//        String a[]=line.split(" ");
        for(String word : a) {
            word = word.toUpperCase();
            Integer count = wordsCount.get(word); // Get current count for this word
//            if (count == null) count = 0; // Initialize on first appearance
//            count++; // Update counter
            wordsCount.put(word, count); // Save the updated value
//        }
//        line=in.readLine();
//    }
//    return wordsCount;
//}