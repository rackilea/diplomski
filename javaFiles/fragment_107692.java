for (int j = 0; j<3; j++) {
    String[] words = str[j].toLowerCase().split(" ");

    // Use Math.min, thanks that it works even if you have only 2 words
    for(int i = 0; i < Math.min(3, words.length()); i++) {
        int count = 0;
        for (char letter : words[i].toCharArray()) {
           // if letter is vowel: count += 1;
        }
        // System.out.println depending on count value
    }
}