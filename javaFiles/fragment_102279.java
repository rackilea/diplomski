import java.nio.ByteOrder;

if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
  System.out.println("Big-endian");
} else {
  System.out.println("Little-endian");
}