// In sender
byte[] bytesToSend = new byte[count];
System.arraycopy(buf, 0, bytesToSend, 0, count);
String encodedBytes = Base64.getEncoder().encodeToString(bytesToSend);
msg.setValue(MType.FILE_BYTE, encodedBytes);

// In receiver
String encodedBytes = (String) msg.getValue(MType.FILE_BYTE);
buf = Base64.getDecoder().decode(encodedBytes);