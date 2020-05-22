System.out.println("Enter a word: ");
String word = keyboard.nextLine();

char currentChar = Character.toLowerCase(word.charAt(0));
while (!((currentChar=='a') || (currentChar=='e') || (currentChar=='i') || (currentChar=='o') || (currentChar=='u'))){ //while the first character isn't a vowel do this:
    word = word.substring(1) + word.charAt(0);
    currentChar = Character.toLowerCase(word.charAt(0));
}

System.out.println(word);