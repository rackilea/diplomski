public class BinaryPermutation extends HashSet<String> {

    private final Iterator<String> iterator;
    private final String token;

    public BinaryPermutation(String token, int n) {
        this.token = token;
        this.initialize("", n);
        this.iterator = super.iterator();
    }

    private void initialize(String string, int iteration) {
        if (iteration == 0) {
           this.add(string);
        } else {
            for (char ch: token.toCharArray()) {
                initialize(string + Character.toString(ch), iteration - 1);
            }
        }
    }
}