public class QRCodeScreen extends MainScreen {

   private String qrCode;
   private static final int QRCODE_WIDTH = 100;
   private BitmapField qrImage;

   public QRCodeScreen(String qrCode) { 
      this.qrCode = "Test String"; 
      qrImage = new BitmapField(new Bitmap(QRCODE_WIDTH, QRCODE_WIDTH),FIELD_HCENTER); 
      qrImage.setBorder(BorderFactory.createBevelBorder(new XYEdges(2, 2, 2, 2))); 

      try { 
         QRCode code = new QRCode();
         Encoder.encode(qrCode, ErrorCorrectionLevel.L, code);
         ByteMatrix barcode = code.getMatrix();
         Bitmap bitmap = BarcodeBitmap.createBitmap(barcode, QRCODE_WIDTH);
         qrImage.setBitmap(bitmap);         
      } 
      catch (Exception e) { 
         e.printStackTrace();
      } 

      add(qrImage); 
   } 
}