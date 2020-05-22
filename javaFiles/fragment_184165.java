import org.apache.commons.codec.binary.Base64;

// Read the byte array from file, DB, etc
byte[] imageByteArray = getImageByteArray();

String base64Image = Base64.encodeBase64String(imageByteArray);