import ch.javasoft.math.BigMath;
import java.math.BigDecimal;

class Tester {
    public static void main(String[] args) {
        long D = 61L, y = 42912791L;
        double a = Math.sqrt(D * y * y + 1);
        double b = Math.sqrt(D * y * y + 2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

        BigDecimal bda = BigMath.sqrt(new BigDecimal(D * y * y + 1), 32);
        BigDecimal bdb = BigMath.sqrt(new BigDecimal(D * y * y + 2), 32);
        System.out.println(bda.toString());
        System.out.println(bdb.toString());
        System.out.println(bda.equals(bdb));
    }
}