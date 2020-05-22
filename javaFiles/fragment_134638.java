public class CharSource {

    private int cursor = 0;
    private int queryLetter = 1;
    private int queried = 0;
    private char[] characters = new char[]{'a', 'b', 'c'};

    public static void main(String[] args) {
        CharSource source = new CharSource();
        for (int i=0; i<40; i++) {
            System.out.println(source.get());
        }
    }

    public char get() {
        char result = characters[cursor];
        if (++queried == queryLetter) {
            if (++cursor == characters.length) {
                cursor = 0;
                queryLetter++;
            }
            queried = 0;
        }
        return result;
    }

}