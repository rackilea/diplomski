/*
 * Special regular expression character ranges relevant for simplification
 * -> see http://docstore.mik.ua/orelly/perl/prog3/ch05_04.htm
 * InCombiningDiacriticalMarks: special marks that are part of "normal" ä,
 * ö, î etc.. IsSk: Symbol, Modifier see
 * http://www.fileformat.info/info/unicode/category/Sk/list.htm IsLm:
 * Letter, Modifier see
 * http://www.fileformat.info/info/unicode/category/Lm/list.htm
 */
private static final Pattern DIACRITICS_AND_FRIENDS = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

private static String stripDiacritics(String str) {
    str = Normalizer.normalize(str, Normalizer.Form.NFD);
    str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
    return str;
}