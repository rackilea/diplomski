String CSVContent = "/* CSV data */";
/**
 *  Decode the bytes using UTF8.  
 */
String decodedStr = StringUtils.newStringUtf8(CSVContent.getBytes("UTF-8"));
/**
 *  Convert the decoded string to Byte array to write to the stream  
 */
Byte [] content = StringUtils.getBytesIso8859_1(decodedStr);