char[] vowels = {'a', 'e', 'i', 'o', 'u'};
String text = "Programming";

for (char c : text.toCharArray()) {
    for (char vowel : vowels) {
        if (c == vowel) {
            System.out.println(text + " contains the vowel: " + vowel);
        }
     }
}