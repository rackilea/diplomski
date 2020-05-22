try {
    bitMatrix = new MultiFormatWriter().encode(
            value,
            BarcodeFormat.DATA_MATRIX.QR_CODE,
            33, 33, null
    );

} catch (IllegalArgumentException | WriterException e1) {
    e1.printStackTrace();
    return null;
}