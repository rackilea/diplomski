byte[] dataBytes = intent.getByteArrayExtra("SCAN_RESULT_BYTE_SEGMENTS_0");
return new IntentResult(contents,
                        formatName,
                        rawBytes,
                        orientation,
                        errorCorrectionLevel,
                        dataBytes);