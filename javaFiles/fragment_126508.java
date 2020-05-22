import java.security.*;
public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        byte[] publicKey = keyGen.genKeyPair().getPublic().getEncoded();
        StringBuffer retString = new StringBuffer();
        retString.append("[");
        for (int i = 0; i < publicKey.length; ++i) {
            retString.append(publicKey[i]);
            retString.append(", ");
        }
        retString = retString.delete(retString.length()-2,retString.length());
        retString.append("]");
        System.out.println(retString); //e.g. [48, 92, 48, .... , 0, 1]
    }
}