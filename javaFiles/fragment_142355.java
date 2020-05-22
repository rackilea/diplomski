HashMap<String, String> lowers = new HashMap<String, String>();
for (String source : source_messageList) {
    lowers.put(getCorpValue(source).toLowerCase(), source);
}
for (String target : target_messageList) {
    final String corpTarget = getCorpValue(target).toLowerCase();
    if(lowers.containsKey(corpTarget)) {
        assertXMLEquals(
            convertSwiftMessageToXML(lowers.get(corpTarget)),
            convertSwiftMessageToXML(target)
        );
    }
}