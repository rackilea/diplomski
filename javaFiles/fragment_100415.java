import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        double[] testArray = {170.56, 43.78, 674.0};

        String encodedTest = encodeLocation(testArray);
        System.out.println(encodedTest+"\n");

        double[] decodedTest = decodeLocation(encodedTest);
        for (double d : decodedTest)
            System.out.println(d);
    }
    private static String encodeLocation(double[] doubleArray) {
        return Base64.getEncoder().encodeToString(doubleToByteArray(doubleArray));
    }
    private static double[] decodeLocation(String base64Encoded) {
        return byteToDoubleArray(Base64.getDecoder().decode(base64Encoded));
    }
    private static byte[] doubleToByteArray(double[] doubleArray) {
        ByteBuffer buf = ByteBuffer.allocate(Double.SIZE / Byte.SIZE * doubleArray.length);
        buf.asDoubleBuffer().put(doubleArray);
        return buf.array();
    }
    private static double[] byteToDoubleArray(byte[] bytes) {
        DoubleBuffer buf = ByteBuffer.wrap(bytes).asDoubleBuffer();
        double[] doubleArray = new double[buf.limit()];
        buf.get(doubleArray);
        return doubleArray;
    }
}