public static String removeLeadNumbersFromXMLTagElements(String xml) throws TransformerException {

    Pattern p = Pattern.compile("(\\<.*?)[0-9]+(.*?\\>)");
    Matcher m = p.matcher(xml);

    StringBuffer result = new StringBuffer();

    while (m.find()) {
        String replace = m.group(1) + "a" + m.group(2);
        m.appendReplacement(result, replace);
    }

    m.appendTail(result);
    return result.toString();
}