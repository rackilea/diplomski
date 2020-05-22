public static void main(String[] args) {

    String[] words = {"ą", "a", "į", "i", "ąąąąą", "aaaaa"};

    Collator en_USCollator = Collator.getInstance(new Locale("en","US"));
    Collator lt_LTCollator = Collator.getInstance(new Locale("lt","LT"));

    sortStrings(en_USCollator, words);
    System.out.println(Arrays.toString(words));
    sortStrings(lt_LTCollator, words);
    System.out.println(Arrays.toString(words));
}

public static void sortStrings(Collator collator, String[] words) {
    String tmp;
    for (int i = 0; i < words.length; i++) {
        for (int j = i + 1; j < words.length; j++) { 
            if (collator.compare(words[i], words[j]) > 0) {
                tmp = words[i];
                words[i] = words[j];
                words[j] = tmp;
            }
        }
    }       
}