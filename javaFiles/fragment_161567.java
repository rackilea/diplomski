import java.security.SecureRandom;
import java.math.BigInteger;

public final class PasswordGenerator {
    private SecureRandom random = new SecureRandom();

    public String nextPassword() {
        return new BigInteger(130, random).toString(32);
    }
}