private static byte[] MakeKey(String key)
 {
     byte[] keyByte = new byte[8];
     byte[] keyResult = Encoding.UTF8.GetBytes(key); 
     for (int i = 0; i<keyResult.Length && i<keyByte.Length; i++) {
         keyByte[i] = keyResult[i];
     }
     return keyByte;
 }