for(int i = 0;i < nodes.getLength(); i++){  
    Element element = (Element) nodes.item(i);

    // retrieve the attribute, then get the value
    Attr pidm = element.getAttributeNode("pidm");
    String pidmString = pidm.getValue();

    // or get the attribute directly
    String pidmDirectString = element.getAttribute("pidm");

    ... // the rest of your code
}