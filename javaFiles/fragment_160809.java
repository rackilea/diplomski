package tequilaguy;

public class ConverterHarness {

//   private static void runOldEncoder() {
//      for (char a='A'; a<='Z'; a++) {
//         for (char b='A'; b<='Z'; b++) {
//            for (char c='A'; c<='Z'; c++) {
//               String str = new String(new char[] { a, b, c});
//               byte[] enc = OldConverter.encode(str);
//               System.out.format("%s : %02X%02X%n", str, enc[0], enc[1]);
//            }
//         }
//      }
//   }

   private static void testNewConverter() {
      for (char a='A'; a<='Z'; a++) {
         for (char b='A'; b<='Z'; b++) {
            for (char c='A'; c<='Z'; c++) {
               String str = new String(new char[] { a, b, c});
               byte[] oldEnc = OldConverter.encode(str);
               byte[] newEnc = NewConverter.encode(str);
               byte[] newEnc2 = NewConverter.encode("@" + str);
               System.out.format("%s : %02X%02X %02X%02X %02X%02X %s %s %n", 
                     str, oldEnc[0], oldEnc[1], newEnc[0], newEnc[1], newEnc2[0], newEnc2[1],
                     NewConverter.decode(newEnc), NewConverter.decode(newEnc2));
            }
         }
      }
   }
   public static void main(String[] args) {
      testNewConverter();
   }

}