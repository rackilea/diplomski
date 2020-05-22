/**
 * Get the number of syllables for a given word
 * @param s the given word
 * @return the number of syllables
 */
public static int getNumberOfSyllables(String s) {
    s = s.trim();
    if (s.length() <= 3) {
        return 1;
    }
    s = s.toLowerCase();
    s = s.replaceAll("[aeiouy]+", "a");
    s = "x" + s + "x";
    return s.split("a").length - 1;
}