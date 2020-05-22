public class TextFileDictionary implements Dictionary {
    public List<String> loadWords() {
        // load words from a text file and return them
        return words;
    }
}

public class DatabaseDictionary implements Dictionary {
    public List<String> loadWords() {
        // load words from database and return them
        return words;
    }
}