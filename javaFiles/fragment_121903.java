package com.example.demo;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;


@Service
public class JWTService {

    private static String SECRET_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIICXgIBAAKBgQCtrKVnwse4anfX+JzM7imShXZUC+QBXQ11A5bOWwHFkXc4nTfE\n" +
            "Or3fJjnRSU5A3IROFU/pVVNiXJNkl7qQZK5mYb8j3NgqX8zZJG7IwLJ/Pm2sRW5Q\n" +
            "j32C/uJum64Q/iEIsCg/mJjDLh1lylEMEuzKgTdWtoeLfxDBL2AJ20qXzQIDAQAB\n" +
            "AoGBAKNXi0GpmjnCOPDxLFg5bvQVfhLSFCGMKQny1DVEtsfgZmbixv5R2R41T4+d\n" +
            "CHJMdEsUFFJ6I7CRLTcg1SDU8IhcAWCBRSNeVuomCHlQG16ti8HxwhiwIcjvDz/z\n" +
            "NC2sL5ZJ2eJnhbtXLdf6pxxO1pA5vLp1AX06IaETO977XvupAkEA+ZgtGZybyUkf\n" +
            "tEA3ekXc5eLoW+zgU0C1fATWcIZ8Iq5YV1BW+3oAzf8HgIbkQh4LM2qa6An3l+vW\n" +
            "NXR4wICHkwJBALIhrcdJqKw36qiyenq+m78klp5SnurQifVt0Sy1GMWyOUqYz5jK\n" +
            "t9sGo9Qn6GDuYe/XGXKWQW25PkEYXxxPPx8CQQCpICyvRidp5VrOURVGjUB5pZ+9\n" +
            "am02/In9V2nXJcnH1kuWHqJSFQGmlEEJHl5dTu5YEMyWnupezzd/UUThbDZxAkAz\n" +
            "TNO5QxNalbf04YG4e9Bq2eSur+iog2pXzkqhb3404UDypNOUkz0jzOO9o8ieschu\n" +
            "xCnGAFPTf7fYE2bAxmnNAkEA0/3bdsvJclquypqP9CQeQnxGwQtWz6+yn07gj3U1\n" +
            "V19mdeKCUZWklRarrcr67u9DdEx+JowyEY/ppzgeQtW01g==\n" +
            "-----END RSA PRIVATE KEY-----";


    public String generateToken() throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        java.security.Security.addProvider(
                new org.bouncycastle.jce.provider.BouncyCastleProvider()
        );
        PemReader pemReader = new PemReader(new StringReader(SECRET_KEY));

        PemObject pemObject;
        pemObject = pemReader.readPemObject();

        KeyFactory factory = KeyFactory.getInstance("RSA");
        byte[] content = pemObject.getContent();
        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
        RSAPrivateKey privateKey = (RSAPrivateKey) factory.generatePrivate(privKeySpec);

        JwtBuilder builder = Jwts.builder().setId("ID")
                .setIssuedAt(new Date())
                .setSubject("Subject")
                .setIssuer("Issuer")
                .signWith(SignatureAlgorithm.RS256, privateKey);
        return builder.compact();
    }
}