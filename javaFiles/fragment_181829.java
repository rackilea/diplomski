public void countLetters(String input) {
    String userInput= input; 
    String s2 = userInput.toLowerCase();
    for ( int i = 0; i < s2.length(); i++ ) {
        char ch=  s2.charAt(i);
        if (ch >= 97 && ch <= 122){
            alphabetArray[ch-'a']++;
            stringLength++; 
        }
    }

}