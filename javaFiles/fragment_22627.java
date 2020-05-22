package com.ni.apps.cartencryptutil;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.ni.apps.cartencryptutil.exceptions.EncryptionException;

/**
 * Security class for encrypting and decrypting Strings (that also works in WC ver 7 and above).
 *
 * @author mkohanek
 *
 */
public class SecurityTools {
  private static final Logger logger = Logger.getLogger(SecurityTools.class);

  private Cipher cipher;
  private IvParameterSpec initVector;
  private SecretKey secretKey;
  private transient ResourceBundle rbConfig;

  private static SecureRandom secureRandom = new SecureRandom();
  private static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
  private static final String ALGORITHM_SHORT = "AES";
  private static final String PBE_ALGORITHM = "PBEWithMD5AndDES";
  private static final String UTF8 = "UTF-8";
  private static final int ITERATIONS = 10000;
  private static final int KEY_LENGTH = 128;

  // exceptions
  private static final String _ERR_ILLEGAL_BLOCK_SIZE = "illegal block size exception.";
  private static final String _ERR_BAD_PADDING = "bad padding exception.";
  private static final String _ERR_INVALIDKEY = "invalidkey exception.";
  private static final String _ERR_PADDING = "padding exception.";
  private static final String _ERR_NO_SUCH_ALGORITHM = "no such algorithm exception.";
  private static final String _ERR_PASSPHRASE_IS_NULL = "passphrase is null.";
  private static final String _ERR_SALT_IS_NULL = "salt is null.";
  private static final String _ERR_INVALID_ALGORITHM = "invalid algorithm exception.";
  private static final String _ERR_UNSUPPORTED_ENCODING = "encoding not supported.";
  private static final String _ERR_INVALID_KEY_SPEC = "invalid key spec exception.";

  /**
   * Constructor
   *
   * @param salt
   *          - for encryption, obtain salt from generateSalt(). for decryption, you should use the same salt used during encryption
   * @throws EncryptionException
   */
  public SecurityTools(String salt) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering Constructor");
    }
    try {
      loadProperties();
      cipher = Cipher.getInstance(AES_ALGORITHM);
      generateIV(salt);
      generateKey(salt);
    } catch (NoSuchAlgorithmException iae) {
      logger.error(_ERR_NO_SUCH_ALGORITHM, iae);
      throw new EncryptionException(_ERR_NO_SUCH_ALGORITHM, iae);
    } catch (NoSuchPaddingException nspe) {
      logger.error(_ERR_PADDING, nspe);
      throw new EncryptionException(_ERR_PADDING, nspe);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("exiting Constructor");
    }
  }

  /**
   * Constructor
   *
   * @param salt
   *          - for encryption, obtain salt from generateSalt(). for decryption, you should use the same salt used during encryption
   * @param passPhrase
   *          - Allows client to pass in a passphrase it wants to use rather than use the one this library defines. This must also be used when decrypting. The length limit for this key is 16
   *          characters
   * @throws EncryptionException
   */
  public SecurityTools(String salt, String passPhrase) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering Constructor");
    }
    try {
      loadProperties();
      cipher = Cipher.getInstance(AES_ALGORITHM);
      generateIV(salt);
      generateKey(salt, passPhrase);
    } catch (NoSuchAlgorithmException iae) {
      logger.error(_ERR_NO_SUCH_ALGORITHM, iae);
      throw new EncryptionException(_ERR_NO_SUCH_ALGORITHM, iae);
    } catch (NoSuchPaddingException nspe) {
      logger.error(_ERR_PADDING, nspe);
      throw new EncryptionException(_ERR_PADDING, nspe);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("exiting Constructor");
    }
  }

  /**
   * Encrypts a given plain text String, and returns the encrypted String
   *
   * @param plainText
   * @return
   * @throws EncryptionException
   */
  public String encrypt(String plainText) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering encrypt");
    }

    String encryptedKey = null;
    try {
      byte[] byteToEncrypt = plainText.getBytes(UTF8);
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, initVector, new SecureRandom());
      byte[] encryptedBytes = cipher.doFinal(byteToEncrypt);
      encryptedKey = DatatypeConverter.printBase64Binary(encryptedBytes);
    } catch (IllegalArgumentException iae) {
      logger.error(_ERR_PASSPHRASE_IS_NULL, iae);
      throw new EncryptionException(_ERR_PASSPHRASE_IS_NULL, iae);
    } catch (InvalidKeyException ike) {
      logger.error(_ERR_INVALIDKEY, ike);
      throw new EncryptionException(_ERR_INVALIDKEY, ike);
    } catch (BadPaddingException bpe) {
      logger.error(_ERR_BAD_PADDING, bpe);
      throw new EncryptionException(_ERR_BAD_PADDING, bpe);
    } catch (IllegalBlockSizeException bpe) {
      logger.error(_ERR_ILLEGAL_BLOCK_SIZE, bpe);
      throw new EncryptionException(_ERR_ILLEGAL_BLOCK_SIZE, bpe);
    } catch (UnsupportedEncodingException uee) {
      logger.error(_ERR_UNSUPPORTED_ENCODING, uee);
      throw new EncryptionException(_ERR_UNSUPPORTED_ENCODING, uee);
    } catch (InvalidAlgorithmParameterException iape) {
      logger.error(_ERR_INVALID_ALGORITHM, iape);
      throw new EncryptionException(_ERR_INVALID_ALGORITHM, iape);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting encrypt");
    }

    return encryptedKey;
  }

  /**
   * Decrypts a given encrypted String, and returns the plain text String
   *
   * @param cipherTextStr
   * @return
   * @throws EncryptionException
   */
  public String decrypt(String cipherTextStr) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering decrypt");
    }

    String cleartext = null;
    try {
      cipher.init(Cipher.DECRYPT_MODE, secretKey, initVector);
      byte[] plainByte = cipher.doFinal(DatatypeConverter.parseBase64Binary(cipherTextStr));
      cleartext = new String(plainByte);
    } catch (InvalidAlgorithmParameterException iape) {
      logger.error(_ERR_INVALID_ALGORITHM, iape);
      throw new EncryptionException(_ERR_INVALID_ALGORITHM, iape);
    } catch (IllegalArgumentException iae) {
      logger.error(_ERR_PASSPHRASE_IS_NULL, iae);
      throw new EncryptionException(_ERR_PASSPHRASE_IS_NULL, iae);
    } catch (InvalidKeyException ike) {
      logger.error(_ERR_INVALIDKEY, ike);
      throw new EncryptionException(_ERR_INVALIDKEY, ike);
    } catch (BadPaddingException bpe) {
      logger.error(_ERR_BAD_PADDING, bpe);
      throw new EncryptionException(_ERR_BAD_PADDING, bpe);
    } catch (IllegalBlockSizeException bpe) {
      logger.error(_ERR_ILLEGAL_BLOCK_SIZE, bpe);
      throw new EncryptionException(_ERR_ILLEGAL_BLOCK_SIZE, bpe);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting decrypt");
    }

    return cleartext;
  }

  /**
   * Creates the IV using Secure Random Number Generator and an empty 16byte array
   *
   * @return
   */
  private void generateIV(String salt) {
    if (logger.isDebugEnabled()) {
      logger.debug("entering generateIV");
    }

    byte[] newSeed = DatatypeConverter.parseBase64Binary(salt);
    initVector = new IvParameterSpec(newSeed);

    if (logger.isDebugEnabled()) {
      logger.debug("exiting generateIV");
    }
  }

  /**
   * Generates the Key used for decryption and encryption using passphrase from properties file on library
   *
   ** @param saltStr
   * @return
   * @throws EncryptionException
   */
  private void generateKey(String saltStr) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering generateKey");
    }

    try {
      String passPhraseStr = rbConfig.getString("passphrase");
      if (StringUtils.isEmpty(passPhraseStr)) {
        throw new EncryptionException(_ERR_PASSPHRASE_IS_NULL);
      }
      if (StringUtils.isEmpty(saltStr)) {
        throw new EncryptionException(_ERR_SALT_IS_NULL);
      }

      byte[] salt = DatatypeConverter.parseBase64Binary(saltStr);

      SecretKeyFactory factory = SecretKeyFactory.getInstance(PBE_ALGORITHM);
      SecretKey tmp = factory.generateSecret(new PBEKeySpec(passPhraseStr.toCharArray(), salt, ITERATIONS, KEY_LENGTH));
      secretKey = new SecretKeySpec(tmp.getEncoded(), ALGORITHM_SHORT);
    } catch (NoSuchAlgorithmException iae) {
      logger.error(_ERR_NO_SUCH_ALGORITHM, iae);
      throw new EncryptionException(_ERR_NO_SUCH_ALGORITHM, iae);
    } catch (InvalidKeySpecException e) {
      logger.error(_ERR_INVALID_KEY_SPEC, e);
      throw new EncryptionException(_ERR_INVALID_KEY_SPEC, e);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting generateKey");
    }
  }

  /**
   * Generates the Key used for decryption and encryption using passphrase passed in
   *
   * @param saltStr
   * @param passPhrase
   * @throws EncryptionException
   */
  private void generateKey(String saltStr, String passPhrase) throws EncryptionException {
    if (logger.isDebugEnabled()) {
      logger.debug("entering generateKey");
    }

    try {
      if (StringUtils.isEmpty(passPhrase)) {
        throw new EncryptionException(_ERR_PASSPHRASE_IS_NULL);
      }
      if (StringUtils.isEmpty(saltStr)) {
        throw new EncryptionException(_ERR_SALT_IS_NULL);
      }

      byte[] salt = DatatypeConverter.parseBase64Binary(saltStr);

      SecretKeyFactory factory = SecretKeyFactory.getInstance(PBE_ALGORITHM);
      SecretKey tmp = factory.generateSecret(new PBEKeySpec(passPhrase.toCharArray(), salt, ITERATIONS, KEY_LENGTH));
      secretKey = new SecretKeySpec(tmp.getEncoded(), ALGORITHM_SHORT);
    } catch (NoSuchAlgorithmException iae) {
      logger.error(_ERR_NO_SUCH_ALGORITHM, iae);
      throw new EncryptionException(_ERR_NO_SUCH_ALGORITHM, iae);
    } catch (InvalidKeySpecException e) {
      logger.error(_ERR_INVALID_KEY_SPEC, e);
      throw new EncryptionException(_ERR_INVALID_KEY_SPEC, e);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("exiting generateKey");
    }
  }

  /**
   * This generates a random value of user defined size that can be used to encrypt data. The decrypting client will then need to access this value to be able to decrypt
   *
   * @return
   */
  public static String generateSaltStr(int size) {
    String salt = null;
    byte[] newSeed = secureRandom.generateSeed(size);
    salt = DatatypeConverter.printBase64Binary(newSeed);

    return salt;
  }

  /**
   * This generates a random 16 bit value that can be used to encrypt data. The decrypting client will then need to access this value to be able to decrypt
   *
   * @return
   */
  public static String generateSaltStr() {
    String salt = null;
    byte[] newSeed = secureRandom.generateSeed(16);
    salt = DatatypeConverter.printBase64Binary(newSeed);

    return salt;
  }

  /**
   * Loads properties files (call before attempting to read any properties files)
   */
  private void loadProperties() {
    try {
      rbConfig = ResourceBundle.getBundle("application", Locale.US);
    } catch (MissingResourceException ie) {
      logger.fatal(
          "FATAL: SecurityTools.loadProperties Cannot read the properties file.  Please ensure the file is on the classpath.");
    } catch (Exception e) {
      logger.fatal(
          "FATAL: SecurityTools.loadProperties Cannot read the properties file.  Please ensure the file is on the classpath.");
    }
  }

  /**
   * Test method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] message = { "mkohanek", "9248547896548752345", "okok234234234okok467467",
        "12" };
    String result = null;
    try {
      // ASYMMETRIC TEST - use this block to test values are usable over separate sessions by taking output from loop below and using it here for subsequent calls
      // String previousSalt = "jriUh+01HlHw4g3mO9PLcw==";
      // SecurityTools asSecTool = new SecurityTools(previousSalt);
      // String previousEncryptedValue = "nFVxkzdx+psiUVkCW5NztQ==";
      // System.out.println("should decrypt to an expected value - " + asSecTool.decrypt(previousEncryptedValue));
      // END ASYMMETRIC TEST

      // SYMMETRIC TEST - tests that single requests will encrypt and decrypt successfully
      String salt = generateSaltStr(16);
      System.out.println("salt - " + salt);
      SecurityTools secTool = new SecurityTools(salt);
      for (String mess : message) {
        result = secTool.encrypt(mess);
        System.out.println(result);
        result = secTool.decrypt(result);
        System.out.println(result);
      }
      // END SYMMETRIC TEST
    } catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();

    }
  }

}