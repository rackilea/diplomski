public static Map<String, Integer> sortWords(BufferedReader in) throws IOException{
//    String line = "";
    Map<String, Integer> wordsCount = new HashMap<>();
//
//    while((line=in.readLine())!=null) {
//        String a[]=line.split(" ");
//        for(int i = 0; i < a.length; i++) {
//            a[i] = a[i].toUpperCase();
            Integer count = wordsCount.get(a[i]); // Get current count for this word
            if (count == null) count = 0; // Initialize on first appearance
            count++; // Update counter
            wordsCount.put(a[i], count); // Save the updated value
//        }
//        line=in.readLine();
//    }
//    return words;
//}