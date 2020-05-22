import java.io.IOException;

public class Echo {
    public static void main(String[] args) throws InterruptedException, IOException {
        final byte[] data = new byte[Test.BODY_LENGTH + Test.END_MARKER.length];
        int index = 0;
        outer: while (true) {
            data[index++] = (byte) System.in.read();
            final int dataOffset = index - Test.END_MARKER.length;
            if (dataOffset < 0) {
                continue;
            }
            for (int i = 0; i < Test.END_MARKER.length; i++) {
                if (data[dataOffset + i] != Test.END_MARKER[i]) {
                    continue outer;
                }
            }
            System.out.print(new String(data, 0, index));
            return;
        }
    }
}