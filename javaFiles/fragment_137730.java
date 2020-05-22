protected static boolean validUTF8(byte[] input) { 
  UniversalDetector detector = new UniversalDetector(null); 
  detector.handleData(input, 0, input.length); 
  detector.dataEnd(); 
  if ("UTF-8".equals(detector.getDetectedCharset())) { 
   return true; 
  } 
  return false; 
 }