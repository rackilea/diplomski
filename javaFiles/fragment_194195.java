import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
...
public void encrypt(File inputFile, File outputFile) throws Exception {

    AEADBlockCipher cipher = getEncryptionCipher();
    // Following code as before (but with fixes described above)
    ...
}

public AEADBlockCipher getEncryptionCipher() throws Exception {

    AEADBlockCipher cipher = new GCMBlockCipher(new AESEngine());
    cipher.init(true, // encryption 
        new AEADParameters(
            new KeyParameter(getSecretKey().getEncoded()),  
            128, // tag length
            getInitializationVector(),                      
            "Optional Associated Data".getBytes()));                    
    return cipher;
}
...