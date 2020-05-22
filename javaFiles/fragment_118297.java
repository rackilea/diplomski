public static String removeFinalSeven(String str) {
     if (str.length() < 7) {
         return ""; //return whatever you want to happen in this scenario
     }
     return str.substring(0, str.length() - 7);
 }