import android.util.Log;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPLiteralData;
import org.bouncycastle.openpgp.PGPLiteralDataGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

import static android.support.constraint.Constraints.TAG;

public class RSAEncryption {

static dataToBeEncrypt = "Hello";
static String publickey = "-----BEGIN PGP PUBLIC KEY BLOCK-----\n" +
        "\n" +
        "mI0EXEr27gEEALybxOEubZ39PX1t+oU9iXhTTmqrc/+ha+J6TYd+yvYcNEBIOzPI\n" +
        "1fG2Tz30zJYwT9uZOyW7LAGKRcsIH6p4SiKGaEYBLEWuCQrGfXPAAXaH+WNsKOmz\n" +
        "SAZilPwugEcWknIUDZzfU0AD8PPCLqhJM6Ij7AJ/SNa2xUIsyUW+PwBdABEBAAG0\n" +
        "BWplZXRziM4EEwEKADgWIQRp0+dcK5ZTXht9TIcw0CiFbn2j6gUCXEr27gIbAwUL\n" +
        "CQgHAgYVCgkICwIEFgIDAQIeAQIXgAAKCRAw0CiFbn2j6um7A/9Ttzl8xHa4MvuF\n" +
        "htOEAb6sXOk17B9BQyd3bkUCYtBjmFA3Q7XzWln5lm2QQTxW+AnlVJYwQS5zvVC0\n" +
        "8WgPh6XP9sCi6/2ar748wpS8dL1wEAwaMOSYGEDCUpmW2uEGsrsAKfiMlKGhLiPC\n" +
        "uUvPJ0x2jjHn9HHO1e9BES9tlkRPJLiNBFxK9u4BBADQtF6EajJMi2IPsVDR6PTX\n" +
        "swjGgVbYKqwZRUwfLecJ95VeiQzznWUMpWFze4ESlAjCYeJf37voDazs6Ol5Uqz7\n" +
        "7d5GurEk4kNjQp4Pm+chFQWLWU1seMghyJqsXCjWApy0lNJ2YPNbYKUqdJsZpJgT\n" +
        "7qofPvEEPlGRRqzZxdN8oQARAQABiLYEGAEKACAWIQRp0+dcK5ZTXht9TIcw0CiF\n" +
        "bn2j6gUCXEr27gIbDAAKCRAw0CiFbn2j6ky9BACgADAD/VIFIUjuQtNa4GEcAS0T\n" +
        "vtJvsL26qW/Gohl5nb1ix7MLBwiH/l1Co6K52GKAVUrZBCnjkJW5zyGTKUkPGbGY\n" +
        "Loh481phsvpYgXHqol7UQivBoF14EO1dNmn61QFRn7D3zhNirziOKQl3kLSuEdc5\n" +
        "VpRF7ubkHL3jRrdQFA==\n" +
        "=/lmV\n" +
        "-----END PGP PUBLIC KEY BLOCK-----";

public static void main (String[] args){
    String encrypted = null;
    try {
        encrypted = encryptToFile(dataToBeEncrypt, publicKey);
    } catch (Exception e) {
        Log.i(TAG, "Exception: " + e);
    }
    return encrypted;
}

public static String encryptToFile(String inputdata, String keyFile) throws Exception {
    Security.addProvider(new BouncyCastleProvider());
    byte[] original = inputdata.getBytes();
    InputStream secKey = new ByteArrayInputStream(keyFile.getBytes("UTF-8"));
    byte[] encrypted = encrypt(original, readPublicKey(secKey), true, true);
    return new String(encrypted);
}

private static PGPPublicKey readPublicKey(InputStream in) throws IOException, PGPException {
    PGPPublicKey k = null;
    in = PGPUtil.getDecoderStream(in);
    PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in);
    Iterator rIt = pgpPub.getKeyRings();
    while (rIt.hasNext()) {
        PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
        Iterator kIt = kRing.getPublicKeys();
        while (kIt.hasNext()) {
            k = (PGPPublicKey) kIt.next();
            if (k.isEncryptionKey()) {
                break;
            }
        }
    }
    return k;
}

/**
 * Simple PGP encryptor between byte[].
 *
 * @param clearData
 *            The test to be encrypted
 * @param //passPhrase
 *            The pass phrase (key). This method assumes that the key is a
 *            simple pass phrase, and does not yet support RSA or more
 *            sophisiticated keying.
 * @param //fileName
 *            File name. This is used in the Literal Data Packet (tag 11)
 *            which is really inly important if the data is to be related to
 *            a file to be recovered later. Because this routine does not
 *            know the source of the information, the caller can set
 *            something here for file name use that will be carried. If this
 *            routine is being used to encrypt SOAP MIME bodies, for
 *            example, use the file name from the MIME type, if applicable.
 *            Or anything else appropriate.
 *
 * @param armor
 * @return encrypted data.
 * @exception IOException
 * @exception PGPException
 * @exception NoSuchProviderException
 */
public static byte[] encrypt(byte[] clearData, PGPPublicKey encKey, boolean withIntegrityCheck, boolean armor)
        throws IOException, PGPException, NoSuchProviderException {

    ByteArrayOutputStream encOut = new ByteArrayOutputStream();

    OutputStream out = encOut;
    if (armor) {
        out = new ArmoredOutputStream(out);
    }

    ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
            PGPCompressedDataGenerator.ZIP);
    OutputStream cos = comData.open(bOut); // open it with the final
    // destination
    PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();

    // we want to generate compressed data. This might be a user option
    // later,
    // in which case we would pass in bOut.
    OutputStream pOut = lData.open(cos, // the compressed output stream
            PGPLiteralData.BINARY, "", // "filename" to store
            clearData.length, // length of clear data
            new Date() // current time
    );
    pOut.write(clearData);
    lData.close();
    comData.close();

    PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(
            PGPEncryptedData.AES_128, withIntegrityCheck, new SecureRandom(),
            "BC");

    cPk.addMethod(encKey);
    byte[] bytes = bOut.toByteArray();

    OutputStream cOut = cPk.open(out, bytes.length);
    cOut.write(bytes); // obtain the actual bytes from the compressed stream
    cOut.close();
    out.close();
    return encOut.toByteArray();
    }
}