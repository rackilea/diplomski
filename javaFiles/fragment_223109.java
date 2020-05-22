import java.util.*;

public class Phonkw {
    static Map<String, String> consonnantReplace = new HashMap<String, String>();
    static {
         consonnantReplace.put("BW", "BOU");
         consonnantReplace.put("CW", "COU");
         consonnantReplace.put("DW", "DOU");
         consonnantReplace.put("FW", "FOU");
         consonnantReplace.put("GW","GOU");
         consonnantReplace.put("HW","HOU");
         consonnantReplace.put("JW", "JOU");
         consonnantReplace.put("KW", "KOU");
         consonnantReplace.put("LW", "LOU");
         consonnantReplace.put("MW", "MOU");
         consonnantReplace.put("NW", "NOU");
         consonnantReplace.put("PW", "POU");
         consonnantReplace.put("QW", "QOU");
         consonnantReplace.put("RW", "ROU");
         consonnantReplace.put("SW", "SOU");
         consonnantReplace.put("TW", "TOU");
         consonnantReplace.put("VW","VOU");
         consonnantReplace.put("WW", "WOU");
         consonnantReplace.put("XW","XOU");
         consonnantReplace.put("ZW", "ZOU");            
    }

    public static String phonkw1(final String tampon){
        if (tampon == null){
            return "";
        }
        if (tampon.length() >= 2) {
            final String key = tampon.substring(0, 2);
            if (consonnantReplace.containsKey(key)) {
                return consonnantReplace.get(key) + tampon.substring(2);
            }
        }
        return tampon;
    }

    public static void main(final String... args) {
        for (final String arg : args)
            System.out.println(phonkw1(arg));
    }
}