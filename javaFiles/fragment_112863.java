class ForTest {
    public static void main (String args[]) throws java.io.IOException {

        int i;

        System.out.println ("Press S to stop.");
        char c;
        for (i = 0; (c = (char) System.in.read()) != 'S'; i++) {
            System.out.println ("Pass #" + i + "; c=" + (int) c);
        }
    }
}