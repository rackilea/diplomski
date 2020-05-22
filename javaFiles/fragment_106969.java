public Map<Character, Integer> getFrequency(String str){

    String vowels = "aeiouAEIOU";
    Map<Character, Integer> freqMap = new HashMap<Character, Integer>();

    for(int i=0;i<str.length(); i++) {

        char ch = str.charAt(i);

        // If character is a not consonant.. continue with next iteration

        if (vowels.contains(ch)) {
            continue;
        }

        Integer val = freqMap.get(ch);

        if (val != null) {
            // Put new entry in Map.. With character and count = 1

        } else {
            // Increment val by 1, and update the map for this character
        }

    }
    return freqMap;
}