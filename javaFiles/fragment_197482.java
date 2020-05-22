public class Test {
    public static void main(String[] args) throws IOException {
        for(int i; (i = System.in.read()) != -1;) {
            System.out.write((byte)i);
        }
    }
}