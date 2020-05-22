public static void updateTemplateArray(char[] tmpArr, String sPhrase, char guess) {

    for (int i = 0; i < sPhrase.length(); i++) {
        if (guess == sPhrase.charAt(i)) {
            tmpArr[i] = guess;
        }
    }
}

...

String phrase = "foo bar";
char[] arr = new char[phrase.length()];
Arrays.fill(arr, '?');

//guessing time
updateTemplateArray(arr, phrase, 'f');
System.out.println(arr);
updateTemplateArray(arr, phrase, 'b');
System.out.println(arr);
updateTemplateArray(arr, phrase, 'x');
System.out.println(arr);