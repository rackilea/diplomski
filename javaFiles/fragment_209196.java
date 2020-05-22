public void log(String s){
    s = s.replaceAll("\n", "<br/>");
    try {
//            logKit.insertHTML(logDoc, logDoc.getLength(), s, 0, 0, null);
        logDoc.insertAfterEnd(logDoc.getCharacterElement(logDoc.getLength()), s);
    } catch (Exception e) {
        e.printStackTrace();
    }
}