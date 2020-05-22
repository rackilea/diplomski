import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

final class MarkovChain {

    private static final BreakIterator sentenceIterator = BreakIterator.getSentenceInstance();
    private static final BreakIterator wordIterator = BreakIterator.getWordInstance();

    private static final Map<String, List<String>> singleWords = new TreeMap<>();
    private static final Map<String, List<String>> dictionary = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        String text = new String(Files.readAllBytes(Paths.get("text.txt")), Charset.defaultCharset());
        addDictionary(text);
        StringBuilder output = new StringBuilder();
        generateSentence(singleWords, dictionary, output, 5);
        System.out.println(output.toString());
    }

    public static void addDictionary(String string) {
        string = string.toLowerCase().trim();
        for (final String sentence : splitSentences(string)) {
            String lastWord = null, lastLastWord = null;
            for (final String word : addDots(splitWords(sentence))) {
                if (lastLastWord != null) {
                    final String key = lastLastWord + ' ' + lastWord;
                    List<String> value = dictionary.get(key);
                    if (value == null)
                        value = new ArrayList<>();
                    value.add(word);
                    dictionary.put(key, value);
                }
                if (lastWord != null) {
                    final String key = lastWord;
                    List<String> value = singleWords.get(key);
                    if (value == null)
                        value = new ArrayList<>();
                    value.add(word);
                    singleWords.put(key, value);
                }
                lastLastWord = lastWord;
                lastWord = word;
            }
        }
    }

    private static List<String> splitSentences(final String string) {
        sentenceIterator.setText(string);
        final List<String> sentences = new ArrayList<>();
        for (int start = sentenceIterator.first(), end = sentenceIterator.next(); end != BreakIterator.DONE; start = end, end = sentenceIterator.next()) {
            sentences.add(string.substring(start, end).trim());
        }
        return sentences;
    }

    private static List<String> splitWords(final String string) {
        wordIterator.setText(string);
        final List<String> words = new ArrayList<>();
        for (int start = wordIterator.first(), end = wordIterator.next(); end != BreakIterator.DONE; start = end, end = wordIterator.next()) {
            String word = string.substring(start, end).trim();
            if (word.length() > 0 && Character.isLetterOrDigit(word.charAt(0)))
                words.add(word);
        }
        return words;
    }

    private static List<String> addDots(List<String> words) {
        words.add(0, ".");
        words.add(".");
        return words;
    }

    public static void generateSentence(Map<String, List<String>> singleWords,
            Map<String, List<String>> dictionary, StringBuilder target, int count) {
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            String w1 = ".";
            String w2 = pickRandom(singleWords.get(w1), r);
            while (w2 != null) {
                target.append(w2).append(" ");              
                if (w2.equals("."))
                    break;
                String w3 = pickRandom(dictionary.get(w1 + " " + w2), r);
                w1 = w2;
                w2 = w3;
            }
            target.append("\n");
        }
    }

    private static String pickRandom(List<String> alternatives, Random r) {
        return alternatives.get(r.nextInt(alternatives.size()));
    }
}