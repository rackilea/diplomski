String removeSecrets(String input){
    StringBuilder sb = new StringBuilder(input);

    String sidStart = "&amp;sid=";
    String sidEnd = "\"";

    int posStart = 0;
    while ((posStart = sb.indexOf(sidStart, posStart)) >= 0) {
        int posEnd = sb.indexOf(sidEnd, posStart);
        if (posEnd < 0)     // delete as far as possible - YMMV
            posEnd = sb.length();
        sb.delete(posStart, posEnd);
    }

    return sb.toString();
}