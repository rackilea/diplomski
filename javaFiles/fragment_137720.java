public String[] extractFirstSentences() {
    String myText = getText();
    String[] paragraphs = myText.split("\\n");
    List<String> result = new ArrayList<String>();
    for (String paragraph : paragraphs) {
        result.add(paragraph.split("[\\.\\?\\!][\\r\\n\\t ]+")[0] + ".");
    }

    return result.toArray(new String[result.size()]);
}