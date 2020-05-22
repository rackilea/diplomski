import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;
import java.nio.ByteBuffer;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.POIXMLDocumentPart;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.openxmlformats.schemas.presentationml.x2006.main.*;

import org.apache.poi.poifs.crypt.CryptoFunctions;
import org.apache.poi.poifs.crypt.HashAlgorithm;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.lang.reflect.Field;

public class RORecommendedTest {

 //password hashed using the low-order word algorithm defined in §14.7.1 of ECMA-376
 static short getPasswordHash(String szPassword) {
  int wPasswordHash;
  byte[] pch = szPassword.getBytes();
  int cchPassword = pch.length;
  wPasswordHash = 0;
  if (cchPassword > 0) {
   for (int i = cchPassword; i > 0; i--) {
    wPasswordHash = ((wPasswordHash >> 14) & 0x01) | ((wPasswordHash << 1) & 0x7FFF);
    wPasswordHash ^= pch[i-1];
   }
   wPasswordHash = ((wPasswordHash >> 14) & 0x01) | ((wPasswordHash << 1) & 0x7FFF);
   wPasswordHash ^= cchPassword;
   wPasswordHash ^= (0x8000 | ('N' << 8) | 'K');
  }
  return (short)(wPasswordHash);
 }

 public static void main(String[] args) throws Exception {

  // Open an Excel workbook and set ReadOnlyRecommended
  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("ExcelTest.xlsx"));
  CTWorkbook ctWorkbook = workbook.getCTWorkbook();
  CTFileSharing ctfilesharing = ctWorkbook.getFileSharing();
  if (ctfilesharing == null) ctfilesharing = ctWorkbook.addNewFileSharing();
  ctfilesharing.setReadOnlyRecommended(true);
  ctfilesharing.setUserName("user");

  short passwordhash = getPasswordHash("baafoo");

  byte[] bpasswordhash = ByteBuffer.allocate(2).putShort(passwordhash).array();
  ctfilesharing.setReservationPassword(bpasswordhash);

  workbook.write(new FileOutputStream("ExcelTestRORecommended.xlsx"));
  workbook.close();


  // Open a Word document and set read only recommended aka WriteProtection
  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTest.docx"));

  POIXMLDocumentPart part = null;
  for (int i = 0; i < document.getRelations().size(); i++) {
   part = document.getRelations().get(i);
   if (part instanceof XWPFSettings) break;
  }
  if (part instanceof XWPFSettings) {
   XWPFSettings settings = (XWPFSettings)part;

   Field _ctSettings = XWPFSettings.class.getDeclaredField("ctSettings"); 
   _ctSettings.setAccessible(true); 
   CTSettings ctSettings = (CTSettings)_ctSettings.get(settings);

   CTWriteProtection ctwriteprotection = ctSettings.getWriteProtection();
   if (ctwriteprotection == null) ctwriteprotection = ctSettings.addNewWriteProtection();
   ctwriteprotection.setRecommended(STOnOff.ON);

   ctwriteprotection.setCryptProviderType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STCryptProv.RSA_FULL);
   ctwriteprotection.setCryptAlgorithmClass(org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgClass.HASH);
   ctwriteprotection.setCryptAlgorithmType(org.openxmlformats.schemas.wordprocessingml.x2006.main.STAlgType.TYPE_ANY);
   ctwriteprotection.setCryptAlgorithmSid(BigInteger.valueOf(4)); //SHA-1
   ctwriteprotection.setCryptSpinCount(BigInteger.valueOf(100000));

   SecureRandom random = new SecureRandom();
   byte[] salt = random.generateSeed(16);
   byte[] hash = CryptoFunctions.hashPassword("baafoo", HashAlgorithm.sha1, salt, 100000, false);

   ctwriteprotection.setHash(hash);
   ctwriteprotection.setSalt(salt);
  }

  document.write(new FileOutputStream("WordTestRORecommended.docx"));
  document.close();

  // Open a PowerPoint show and set read only recommended aka ModifyVerifier
  XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream("PowerPntTest.pptx"));
  CTPresentation ctpresentation = slideShow.getCTPresentation();
  CTModifyVerifier ctmodifyverifier = ctpresentation.getModifyVerifier();
  if (ctmodifyverifier == null) ctmodifyverifier = ctpresentation.addNewModifyVerifier();

  ctmodifyverifier.setCryptProviderType(org.openxmlformats.schemas.presentationml.x2006.main.STCryptProv.RSA_FULL);
  ctmodifyverifier.setCryptAlgorithmClass(org.openxmlformats.schemas.presentationml.x2006.main.STAlgClass.HASH);
  ctmodifyverifier.setCryptAlgorithmType(org.openxmlformats.schemas.presentationml.x2006.main.STAlgType.TYPE_ANY);
  ctmodifyverifier.setCryptAlgorithmSid(4); //SHA-1
  ctmodifyverifier.setSpinCount(100000);

  SecureRandom random = new SecureRandom();
  byte[] salt = random.generateSeed(16);
  byte[] hash = CryptoFunctions.hashPassword("baafoo", HashAlgorithm.sha1, salt, 100000, false);

  ctmodifyverifier.setHashData(java.util.Base64.getEncoder().encodeToString(hash));
  ctmodifyverifier.setSaltData(java.util.Base64.getEncoder().encodeToString(salt));

  slideShow.write(new FileOutputStream("PowerPntTestRORecommended.pptx"));
  slideShow.close();

 }
}