import org.bouncycastle.openssl.jcajce.JcaPEMWriter;

import java.io.File;
import java.io.FileWriter;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class Main
{
    public static final int KEY_LENGTH = 2048;

    public static void main(String[] args) throws Exception
    {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        random.nextBytes(new byte[]{}); //toss out the first result to ensure it seeds randomly from the system.

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(KEY_LENGTH, random);
        java.security.KeyPair keyPair = keyGen.genKeyPair();

        System.out.println("public format: " + keyPair.getPublic().getFormat());
        System.out.println("public algorithm: " + keyPair.getPublic().getAlgorithm());

        System.out.println("private format: " + keyPair.getPrivate().getFormat());
        System.out.println("private algorithm: " + keyPair.getPrivate().getAlgorithm());

        JcaPEMWriter writer =  null;
        File keyDir = new File("C:/misc/test_key");

        try
        {
            writer = new JcaPEMWriter(new FileWriter(new File(keyDir, "private_bc.pem")));
            writer.writeObject(keyPair.getPrivate());    
        }
        finally
        {
            if(writer != null)
                writer.close();
        }    
    }
}