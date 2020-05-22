public static void parseText(String text) {
    String[] paragraphs = text.split(PARAGRAPH_SPLIT_REGEX);
    for (String paragraph : paragraphs) {
        System.out.println("Paragraph: " + paragraph.trim());
    }
}