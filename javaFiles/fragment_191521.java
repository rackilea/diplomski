System.out.println("Enter a word: ");
String word = keyboard.nextLine();

while (!isVowel(word.charAt(0))){ //while the first character isn't a vowel do this:
    word = word.substring(1) + word.charAt(0);
}

System.out.println(word);