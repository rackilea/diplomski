public class Couple {

    private char firstChar;
    private int length;

    public Couple(char firstChar, int length) {
        this.length = length;
        this.firstChar = firstChar;
    }

    public static Couple[] create(String[] source) {
        Couple[] couples = new Couple[source.length]; // create the array to hold the return pairs

        for (int i = 0; i < source.length; i++) {
            String entry = source[i];
            if (entry != null) {
                couples[i] = new Couple(entry.charAt(0), entry.length());
            } else {
                // What do you want to do if there's a null value?
                // Until you answer this we'll just leave the corresponding Couple null aswell
            }
        }

        return couples;
    }

    @Override
    public String toString() {
        return "Couple{" +
                "firstChar=" + firstChar +
                ", length=" + length +
                '}';
    }
}