String[] bytes = str_encoded.substring(1, str_encoded.length() - 1).split(", ");

byte[] bytesArray = new byte[bytes.length];
for (int i = 0; i < bytesArray.length; i++) {
    bytesArray[i] = Integer.valueOf(bytes[i]).byteValue();
}

String str_decoded = new String(bytesArray);
System.out.println(str_decoded);