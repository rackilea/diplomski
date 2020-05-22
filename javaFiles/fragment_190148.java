import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;

public class MyKeystoreProvider {
  public KeyStore getKeystore(char[] password) throws GeneralSecurityException, IOException {
    KeyStore keystore = KeyStore.getInstance("jks");
    InputStream input = new FileInputStream(SystemUtils.USER_HOME + File.separator + ".keystore");
    try {
      keystore.load(input, password);
    } catch (IOException e) {
    } finally {
      IOUtils.closeQuietly(input);
    }
    return keystore;
  }
}