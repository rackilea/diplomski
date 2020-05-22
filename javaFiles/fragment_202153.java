public static String alphabet(char letter1, char letter2) { 
    StringBuffer out = new StringBuffer();    
    for (char c = letter1; c < letter2; c++) {
        out.append(c);
    }
    return out.toString();
}