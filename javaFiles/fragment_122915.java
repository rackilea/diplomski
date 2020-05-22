MultiFormatReader reader = new MultiFormatReader();

FileInputStream fis = new FileInputStream(filePath);

BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
    new BufferedImageLuminanceSource(
            ImageIO.read(fis))));

Result result = reader.decode(bitmap);

String originalText = result.getText();
byte[] bytes = originalText.getBytes("ISO-8859-1");
String outputText = new String(bytes, "UTF-8");