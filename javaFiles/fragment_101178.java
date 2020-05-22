import java.util.Base64; //for Java 8
import org.apache.commons.io.FileUtils;

//encode to Base64
byte[] binaryFileBytes = FileUtils.readFileToByteArray(originalTrustFile);
String jsonFieldValue = Base64.getEncoder().encodeToString(binaryFileBytes);

//decode from Base64     
String jsonFieldValue = ... //obtain from your JSON
byte[] binaryFileBytes = Base64.getDecoder().decode(jsonFieldValue);
FileUtils.writeByteArrayToFile(trustFile, binaryFileBytes);