import java.util.BitSet;

public class Main {

    public static void main(String[] args) {
        BitSet bits = new BitSet();
        bits.set(5);
        bits.set(6);
        StringBuilder bitString = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            bitString.append(bits.get(i) ? "1" : "0");
        }
        System.out.println(bitString.toString());
    }
}