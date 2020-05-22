public static String selectCxmlFromXml(String xml) {
    String cxml = "";
    Pattern pattern = Pattern.compile("(<cXML.*</cXML>)", Pattern.DOTALL);
    Matcher matcher = pattern.matcher(xml);
    if (matcher.find()) {
        cxml = matcher.group(1);
    }
    return cxml;
}