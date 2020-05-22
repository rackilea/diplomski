import java.util.Arrays;
import java.util.List;

public class Word {

    private List<String> javaReservedWord = Arrays.asList(
            "abstract", "assert", "boolean", "break",
            "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"
    );

    class WordAndNumber {
        private String word;
        private int lineNumber;

        public WordAndNumber(String word, int lineNumber) {
            this.word = word;
            this.lineNumber = lineNumber;
        }

        public String getWord() {
            return word;
        }

        public int getLineNumber() {
            return lineNumber;
        }
    }

    private WordAndNumber add(String word, int lineNumber) {

        if (javaReservedWord.contains(word)) {
            return null;
        } else {
            // add in DB

            return new WordAndNumber(word, lineNumber);
        }
    }
}