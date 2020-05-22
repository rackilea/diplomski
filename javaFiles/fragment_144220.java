public static String stripQuote(String l) {
    StringBuffer newLine = new StringBuffer();

    for (int i=0; i<l.length(); i++) {
        char ch = l.charAt(i);
        if (ch==8220 || ch==8221 || ch=='\"' || ch=='\'') {
            //do nothing
        }
        else {
            newLine.append(ch);
        }
    }
    return newLine.toString();
}