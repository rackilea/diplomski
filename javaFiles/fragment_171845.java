import java.io.*;
import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.poifs.crypt.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.nio.ByteBuffer;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

public class OOXMLEncryptionTest {

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
System.out.println(wPasswordHash); 
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
System.out.println(passwordhash); 

  byte[] bpasswordhash = ByteBuffer.allocate(2).putShort(passwordhash).array();
  ctfilesharing.setReservationPassword(bpasswordhash);

  workbook.write(new FileOutputStream("ExcelTestRORecommended.xlsx"));
  workbook.close();

  // Now do the encryption
  POIFSFileSystem fs = new POIFSFileSystem();
  EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
  // EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile, CipherAlgorithm.aes192, HashAlgorithm.sha384, -1, -1, null);

  Encryptor enc = info.getEncryptor();
  enc.confirmPassword("foobaa");

  // Read in an existing OOXML file
  OPCPackage opc = OPCPackage.open(new File("ExcelTestRORecommended.xlsx"), PackageAccess.READ_WRITE);
  OutputStream os = enc.getDataStream(fs);
  opc.save(os);
  opc.close();

  // Write out the encrypted version
  FileOutputStream fos = new FileOutputStream("ExcelTestEncrypted.xlsx");
  fs.writeFilesystem(fos);
  fos.close();

 }
}