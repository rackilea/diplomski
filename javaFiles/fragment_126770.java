public static void main(String[] args) {
    int vowel;
    // ==== getVowel ==== 
    int count = 0;
    for (int i = 0; i < "Programming is fun".length(); i++) {
        char ch = Character.toUpperCase("Programming is fun".charAt(i));
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            count++;
        }
    }
    vowel = count;

    int consonant;
    // ==== getConsonant ==== 
    count = 0;
    for (int i = 0; i < "Programming is fun".length(); i++) {
        char ch = Character.toUpperCase("Programming is fun".charAt(i));
        if (!(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && ch >= 'A' && ch <= 'Z') {
            count++;
        }
    }
    consonant = count;

    System.out.println(vowel + " " + consonant);
}