/**
 * FIRST REMOVE ITALICS, THEN BOLD, THEN URL
 */
public static String cleanWikiFormat(CharSequence sequence) {
    return Test.removeUrl(Test.removeBold(Test.removeItalic(sequence)));
}