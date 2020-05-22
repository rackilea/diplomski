public static void main(String[] args) {
          String[] tests = {
                "piabcpiefgpi", "xxxxxxpix", "xpix", "pip", "3.14", "3.14p",
                "hip", "p", "x", "", "pixx", "xyzzy"
          };
          for (String t : tests) {
             System.out.println(t + " --> " + replaceV2(t));
          }
       }

       public static String replaceV1(String a) {
          int i = a.indexOf("pi");
          if (i < 0) {
             return a;
          }
          return replaceV1(
                a.substring(0, i) + "3.14" + a.substring(i + "pi".length()));
       }

       public static String replaceV2(String a) {
          if (a.length() < 2) {
             return a;
          }

          if (a.startsWith("pi")) {
             a = "3.14" + replaceV2(a.substring(2));
          }
          return a.substring(0, 1) + replaceV2(a.substring(1));
       }
    }