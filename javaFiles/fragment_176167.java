package stackOverflow;

public class JavaByteSender {    
    public static void main(String... args) {
    new ScalaByteReceiver().receive(new byte[4]);
    }
}