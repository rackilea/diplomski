/**
 * Checks whether a file is an archive
 *
 * @param    filFile        the file to checks
 * @retuns                  a bollean value indicating the result
 */
 public static Boolean isArchive(File filFile) {  

     try {

         byte[] bytSignature = new byte[] {0x52, 0x61, 0x72, 0x21, 0x1a, 0x07, 0x00};
         FileInputStream fisFileInputStream = new FileInputStream(filFile);

         byte[] bytHeader = new byte[20];
         fisFileInputStream.read(bytHeader);

         Short shoFlags = (short) (((bytHeader[10]&0xFF)<<8) | (bytHeader[11]&0xFF));

         //Check if is an archive
         if (Arrays.equals(Arrays.copyOfRange(bytHeader, 0, 7), bytSignature)) {
             //Check if is a spanned archive
             if ((shoFlags & 0x0100) != 0) {
                 //Check if it the first part of a spanned archive
                 if ((shoFlags & 0x0001) != 0) {
                     return true;
                 } else {
                     return false;
                 }
             } else {
                 return true;
             }
         } else {
             return true;
         }

     } catch (Exception e) {
         return false;
     }

 }