import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;

import java.io.StringReader;
import java.security.Security;
import java.security.interfaces.DSAPublicKey;

public class DSA {
    public static void main(String[] args) throws Exception {
        String key =
            "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBuDCCASwGByqGSM44BAEwggEfAoGBAOwYAcAzXpuw+XCXuNp5zhAzKdhrRguI\n" +
            "uI5kLia8fhRb+1EnFPNpXt4fUS2c/0P0nvzH/TvApizzMkRYJea6rRSW5B+MDjv6\n" +
            "lvrxv+5xBM15kdug033mgSL7wEJIrTLwbe5/djz2oe+pr1KLqs/fvgyKcQyttUWb\n" +
            "5SmwZ+UVx3zfAhUAu0kA2L6VgbvEwpD9sTj5tLyB6Y0CgYEA5GjC+KsPsAH3HZKl\n" +
            "2IwTjX47iNVHyuzr4ZcyXceJ/pi3WR6bQJ6tpf1I2jIE0DOMPlNUwYh0aWBGvoY2\n" +
            "t4d5cwZaW90OS8IAIRFkQS0ywpmJyb7KXqRHwAYdMID88GW0d/KsVB3if0j/9QOo\n" +
            "jhGOrO+kJcZBxUSxINgIIEYFAlEDgYUAAoGBALnHTAZlpoLJZuSBVtnMuRM3cSX4\n" +
            "3IkE9w9FveDV1jX5mmfK7yBVpQFV8eVJfk91ERQ4Dn6ePLUv2dRIt4a0S0qHqadg\n" +
            "zyoFyqkmmUi1kNLyixtRqh+m2gXx0t63HEpZDbEPppdpnlppZquVQh7TyrKSXW9M\n" +
            "TzUkQjFI9UY7kZeK\n" +
            "-----END PUBLIC KEY-----";

        Security.addProvider(new BouncyCastleProvider());
        PEMReader reader = new PEMReader(new StringReader(key));
        DSAPublicKey decoded = (DSAPublicKey) reader.readObject();
        System.out.println(decoded.getClass());
    }
}