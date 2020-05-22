// returns a value < 0 if a < b, a value > 0 if a > b and 0 if a == b
public int compare(Node a, Node b) {
    if (a.count == b.count)
        return a.word.compareTo(b.word);
        // case-insensitive: a.word.toLoweCase().compareTo(b.word.toLowerCase())
    } else {
        return a.count - b.count;
    }
}