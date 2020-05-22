import com.google.zxing.*;

public static String scanQRImage(Bitmap bMap) {
    String contents = null;

    int[] intArray = new int[bMap.getWidth()*bMap.getHeight()];
    //copy pixel data from the Bitmap into the 'intArray' array
    bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());

    LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

    Reader reader = new MultiFormatReader();
    try {
        Result result = reader.decode(bitmap);
        contents = result.getText();
    }
    catch (Exception e) {
        Log.e("QrTest", "Error decoding barcode", e);
    }
    return contents;
}