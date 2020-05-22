public class CaesarCipher {

    private static final int A = (int)'A';
    private static final int Z = (int)'Z';

    public static void main(String[] args) {
        for (String s : args)
            System.out.println(new Encoder(s));
    }

    private static class Encoder {
        private String encoded;
        public Encoder(String s) {
            s = s.toUpperCase();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray())
                sb.append((char)(A + Z - (int)c));
            encoded = sb.toString();
        }

        @Override
        public String toString() { return encoded; }
    }

}