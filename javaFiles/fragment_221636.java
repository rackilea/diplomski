for (String word : list) {
    for (int j = 0; j < word.length(); j++) {
        if (word.charAt(j)=='a'||word.charAt(j)=='e'||word.charAt(j)=='i'||word.charAt(j)=='o'||word.charAt(j)=='u') {
            count++;
        }
    }
}