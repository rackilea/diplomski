public static void main(String[] args) {
    ArrayList<String> string;
    string = new ArrayList<>(Arrays.asList("Mah", "Bob", "mah", "bat", "MAh", "BOb"));
    Map<String, Integer> wordMap = new HashMap<String, Integer>();

    for (String st : string) {
        String input = st.toUpperCase();
        if (wordMap.get(input) != null) {
            Integer count = wordMap.get(input) + 1;
            wordMap.put(input, count);
        } else {
            wordMap.put(input, 1);
        }
    }
    System.out.println(wordMap);
    Object maxEntry = Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    System.out.println("maxEntry = " + maxEntry);
}