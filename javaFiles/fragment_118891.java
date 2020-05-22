import java.nio.ByteBuffer;

public class Main {

    public static void main(String [] args) throws Exception {

        byte [] a1 = {0, 1, 0, 1};
        byte [] a2 = {0, 0, 1, 0};

        boolean eq = ByteBuffer.wrap(a1,0,3).equals(ByteBuffer.wrap(a2,1,3));
        System.out.println("equal: " + eq);
    }
}