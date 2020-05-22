public static void main(String[] args) {

    String s = "This this the has dog cat fish the cat horse";
    String[] words = s.split(" ");
    Map<String, Integer> occurences = new HashMap<String, Integer>();

    for (String word : words) {
        word = word.toLowerCase(); // remove if you want case sensitivity
        if (occurences.containsKey(word)) {
            occurences.put(word, occurences.get(word) + 1);
        } else {
            occurences.put(word, 1);
        }
    }

    for(Entry<String,Integer> en : occurences.entrySet()){
        System.out.println("Word \"" + en.getKey() + "\" appeared " + en.getValue() + " times.");
    }

}