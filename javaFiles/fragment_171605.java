public static void main(String[] args) {
    String[] s = {"Netherlands_Iceland_Norway_Denmark", "Usa_Brazil_Argentina"};
    String[] finalString = mymethod(s);        
    for (int i = 0; i < s.length; i++) {
        System.out.println("" + finalString[i]);
    }
}

static public String[] mymethod(String[] mystring) {
    String ss[] = new String[mystring.length];
    for (int j = 0; j < mystring.length; j++) {
        ss[j] = mystring[j].replace('_', ',');
    }
    return ss;
}