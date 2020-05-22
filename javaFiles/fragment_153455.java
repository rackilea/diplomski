StringBuffer sb = new StringBuffer ();
sb.append ( QRCODE_IDENTIFICATIVO );
// other lines with the content of qrcode

Map<EncodeHintType, Object> qrParam = new HashMap<EncodeHintType, Object> ();
qrParam.put ( EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M );
qrParam.put ( EncodeHintType.CHARACTER_SET, "UTF-8" );

BarcodeQRCode qrcode = new BarcodeQRCode ( sb.toString (), 33, 33, qrParam );
return qrcode.createAwtImage ( Color.BLACK, Color.WHITE );