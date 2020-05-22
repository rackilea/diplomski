import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo; // NOT the 
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;       // javax ones!
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;

    // args[0] = filename args[1] = password
    FileInputStream fis = new FileInputStream(args[0]);
    byte[] buff = new byte[9999]; int len = fis.read(buff); fis.close();
    // could use File.readAllBytes in j8 but my dev machine is old

    // create what PEMParser would have 
    ASN1Sequence derseq = ASN1Sequence.getInstance (Arrays.copyOf(buff,len));
    PKCS8EncryptedPrivateKeyInfo encobj = new PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo.getInstance(derseq));
    // decrypt and convert key
    JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
    InputDecryptorProvider decryptionProv = new JceOpenSSLPKCS8DecryptorProviderBuilder().build(args[1].toCharArray());
    PrivateKeyInfo keyInfo = encobj.decryptPrivateKeyInfo(decryptionProv);
    PrivateKey key = converter.getPrivateKey(keyInfo);

    // now actually use key, this is just a dummy
    System.out.println (key.getAlgorithm());