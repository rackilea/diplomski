import java.nio.ByteBuffer;

public class ByteShow {
  public static void showBytes(ByteBuffer bb) {
    byte[] bytes = bb.array();
    for (byte b : bytes) {
      System.out.format("0x02%x ", b);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    showBytes(ByteBuffer.allocate(4).putInt(0x12345678));
    showBytes(ByteBuffer.allocate(8).putDouble(Math.PI))
    showBytes(ByteBuffer.allocate(2).putChar('@'));
  }
}