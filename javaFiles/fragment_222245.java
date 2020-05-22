static char alphabet[] = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
static String morseCode[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "..-", ".--", "-..-", "-.--", "--..", "|"};

public static void decodeMorse(String morse){
    StringBuilder english = new StringBuilder();

    int codeLength = 0;
    for(int i=0; i<morse.length();i++){

        String code = null;
        // if we met ' ', we can get previous code
        if(morse.charAt(i)==' ' && codeLength>0){
            code = morse.substring(i-codeLength, i);
            codeLength=0;
        }else
        // when we reached end of string we have to get previous code
        if(i==morse.length()-1 && codeLength>0){
            code = morse.substring(i-codeLength, morse.length());
        }
        else{
            codeLength++;
        }

        // if you got the code, find alphabet char for it
        if(code!=null){
            for(int j=0; j<alphabet.length; j++){
                if(code.equals(morseCode[j])){
                    english.append(alphabet[j]);
                }
            }
        }

    }

    System.out.println(english);
}