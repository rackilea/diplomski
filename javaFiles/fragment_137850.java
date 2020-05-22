private void solveChallenge(List<String> words) {
    for(int i=0 ;i<(words.size()); i++) {
        Set<String> result = new TreeSet<>();
        StringBuilder resultant_string = new StringBuilder(words.get(i)); //To store the all anagrams
        for(int j=(i+1); j< words.size(); j++) {
            if (isAnagram(words.get(i), words.get(j))){
                resultant_string.append(" ").append(words.get(j));
                words.remove(j);
                j--;       //If anagram found, stay on the current element
            }
        }
        result.add(resultant_string.toString());
        System.out.println(resultant_string);
    }
}