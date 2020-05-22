public static String encodeQuote(String l) {
    StringBuffer newLine = new StringBuffer();

    for (int i=0; i<l.length(); i++) {
        char ch = l.charAt(i);
        if (ch==8220 || ch==8221 || ch=='\"') {
            newLine.appent("&quot;");
        }
        else if (ch=='<') {
            newLine.appent("&lt;");
        }
        else if (ch=='>') {
            newLine.appent("&gt;");
        }
        else if (ch=='\'') {
            newLine.appent("&#39;");
        }
        else {
            newLine.append(ch);
        }
    }
    return newLine.toString();
}