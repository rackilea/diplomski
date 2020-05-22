package tiesImpl;

/**
 * Class for testing different implementations of prefix tree (Trie).
 *
 * @author lkallas
 */

public class TriesTest {

private static final PrefixTrie<String> googleTrie = new PrefixTrie<>();
private static final Trie<String> krozTrie = new Trie<>();

public static void main(String[] args) {

    //Inserting prefixes to Google implementation of Trie
    googleTrie.put("7", "Russia");
    googleTrie.put("77", "Abkhazia");
    googleTrie.put("746", "Some unknown country");

    //Inserting prefixes to Vladimir Kroz implementation of Trie
    krozTrie.put("7", "Russia");
    krozTrie.put("77", "Abkhazia");
    krozTrie.put("746", "Some unknown country");

    System.out.println("Google version of get: " + googleTrie.get("745878787"));
    System.out.println("Vladimir Kroz version of get: " + krozTrie.get("745878787"));

}

}