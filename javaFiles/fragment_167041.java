static String cyclicLeftShift(String s, int k) {

    String finalString = "";

    char[] newString = s.toCharArray();
    char[] globalSecString = new char[newString.length];

    for(int r=0; r<k; r++) {
        char[] secString = new char[newString.length];
        secString[secString.length-1]=newString[0];

        for(int i=0; i<s.length()-1; i++) { 
            secString[i]= newString[i+1];
        }
        newString = secString;
        globalSecString = secString;
    }

    for(int c=0; c<globalSecString.length; c++){
        finalString+=globalSecString[c];
    }
    return finalString;