package tequilaguy;


public class NewConverter {

   private static final String[] b2s = new String[0x10000];
   private static final int[] s2b = new int[0x10000];
   static { 
      createb2s();
      creates2b();
   }

   /**
    * Create the "byte to string" conversion table.
    */
   private static void createb2s() {
      // Fill 17576 elements of the array with b -> s equivalents.
      // index is the combined byte value of the old encode fn; 
      // value is the String (3 chars). 
      for (char a='A'; a<='Z'; a++) {
         for (char b='A'; b<='Z'; b++) {
            for (char c='A'; c<='Z'; c++) {
               String str = new String(new char[] { a, b, c});
               byte[] enc = OldConverter.encode(str);
               int index = ((enc[0] & 0xFF) << 8) | (enc[1] & 0xFF);
               b2s[index] = str;
               // int value = 676 * a + 26 * b + c - ((676 + 26 + 1) * 'A'); // 45695;
               // System.out.format("%s : %02X%02X = %04x / %04x %n", str, enc[0], enc[1], index, value);
            }
         }
      }
      // Fill 17576 elements of the array with b -> @s equivalents.
      // index is the next free (= not null) array index;
      // value = the String (@ + 3 chars)
      int freep = 0;
      for (char a='A'; a<='Z'; a++) {
         for (char b='A'; b<='Z'; b++) {
            for (char c='A'; c<='Z'; c++) {
               String str = "@" + new String(new char[] { a, b, c});
               while (b2s[freep] != null) freep++;
               b2s[freep] = str;
               // int value = 676 * a + 26 * b + c - ((676 + 26 + 1) * 'A') + (26 * 26 * 26);
               // System.out.format("%s : %02X%02X = %04x / %04x %n", str, 0, 0, freep, value);
            }
         }
      }
   }

   /**
    * Create the "string to byte" conversion table.
    * Done by inverting the "byte to string" table.
    */
   private static void creates2b() {
      for (int b=0; b<0x10000; b++) {
         String s = b2s[b];
         if (s != null) {
            int sval;
            if (s.length() == 3) {
               sval = 676 * s.charAt(0) + 26 * s.charAt(1) + s.charAt(2) - ((676 + 26 + 1) * 'A');
            } else {
               sval = 676 * s.charAt(1) + 26 * s.charAt(2) + s.charAt(3) - ((676 + 26 + 1) * 'A') + (26 * 26 * 26);
            }
            s2b[sval] = b;
         }
      }
   }

   public static byte[] encode(String str) {
      int sval;
      if (str.length() == 3) {
         sval = 676 * str.charAt(0) + 26 * str.charAt(1) + str.charAt(2) - ((676 + 26 + 1) * 'A');
      } else {
         sval = 676 * str.charAt(1) + 26 * str.charAt(2) + str.charAt(3) - ((676 + 26 + 1) * 'A') + (26 * 26 * 26);
      }
      int bval = s2b[sval];
      return new byte[] { (byte) (bval >> 8), (byte) (bval & 0xFF) };
   }

   public static String decode(byte[] b) {
      int bval = ((b[0] & 0xFF) << 8) | (b[1] & 0xFF);
      return b2s[bval];
   }

}