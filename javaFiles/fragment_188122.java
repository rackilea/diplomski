package nl.owlstead.stackoverflow;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadRSAKeyFromText {

    public static void main(String[] args) throws Exception {
        // parse the lines to find the modulus n and public exponent e
        List<String> all = Files.readAllLines(new File(args[0]).toPath());
        String nString = null, eString = null;
        for (String line : all) {
            Pattern nPattern = Pattern.compile("\"n\"\\s*:\\s*\"(.*?)\",?");
            Matcher nMatcher = nPattern.matcher(line);
            if (nMatcher.matches()) {
                nString = nMatcher.group(1).replaceAll("\\s+", "");
            }

            Pattern ePattern = Pattern.compile("\"e\"\\s*:\\s*\"(.*?)\",?");
            Matcher eMatcher = ePattern.matcher(line);
            if (eMatcher.matches()) {
                eString = eMatcher.group(1);
            }
        }

        // decode base 64 (with _ and -, so URL safe)
        Decoder urlDecoder = Base64.getUrlDecoder();
        byte[] nData = urlDecoder.decode(nString);
        byte[] eData = urlDecoder.decode(eString);

        // convert to *positive* integers
        BigInteger n = new BigInteger(1, nData);
        BigInteger e = new BigInteger(1, eData);

        // create RSA specification and convert to key
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(n, e);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        RSAPublicKey pk = (RSAPublicKey) kf.generatePublic(keySpec);
        System.out.println(pk.getAlgorithm());
    }
}