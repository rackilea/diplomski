public String getPackedContent(Element element) {
    if (element != null) {
        String text = element.getTextContent();
        if (text != null) {
            return text.trim().replaceAll("\\s+", " ");
        }
    }
    return "";
}

System.out.print(getPackedContent(myElement)); // "some text of mine"