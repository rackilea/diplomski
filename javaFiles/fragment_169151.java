private final byte[] dataBytes;

IntentResult() {
    this(null, null, null, null, null, null);
}

IntentResult(String contents,
           String formatName,
           byte[] rawBytes,
           Integer orientation,
           String errorCorrectionLevel,
           byte[] dataBytes) {
    this.contents = contents;
    this.formatName = formatName;
    this.rawBytes = rawBytes;
    this.orientation = orientation;
    this.errorCorrectionLevel = errorCorrectionLevel;
    this.dataBytes = dataBytes;
}


/**
* @return raw content of barcode in bytes
*/

public byte [] getDataBytes() {
  return dataBytes;
}