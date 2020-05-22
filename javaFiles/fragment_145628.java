public static void main(String[] args) {
    int startLimit = 2;
    int endLimit = 4;
    String objectSeparator = "],";

    HashMap<String, String> finalMap = new HashMap<>();
    HashMap<String, String> initialMap = new HashMap<>();

    String sList = "[s1, s2, s3, s4, s5, s6],[s7, s8 s9, s10, s11, s12],[s13, s14 ,s15, s16, s17, s18],[s19, s20, s21, s22, s23, s24],[s25, s26, s27, s28, s29, s30]";
    String dList = "[[d1, d2, d3, d4, d5, d6],[d7, d8, d9, d10, d11, d12],[d13, d14 ,d15, d16, d17, d18],[d19, d20, d21, d22, d23, d24],[d25, d26, d27, d28, d29, d30]]";
    String wList = "[w1, w2, w3, w4, w5, w6],[w7, w8, w9, w10, w11, w12],[w13, w14 ,w15, w16, w17, w18],[w19, w20, w21, w22, w23, w24],[w25, w26, w27, w28, w29, w30]";
    String eList = "[e1, e2, e3, e4, e5, e6],[e7, e8, e9, e10, e11, e12],[e13, e14 ,e15, e16, e17, e18],[e19, e20, e21, e22, e23, e24],[e25, e26, e27, e28, e29, e30]";

    initialMap.put("status", sList);
    initialMap.put("data", dList);
    initialMap.put("warning", wList);
    initialMap.put("error", eList);

    Iterator<Entry<String, String>> it = initialMap.entrySet().iterator();
    Entry<String, String> e = null;
    String eValue = null;
    String[] splitted = null;
    while (it.hasNext()) {
        e = it.next();
        eValue = e.getValue();

        // Split each "square bracket object" in a separate string 
        splitted = eValue.split(objectSeparator);

        // Create a new string containing only objects with index between limits
        String limited = "";
        for(int idx = startLimit-1; idx <= endLimit-1; idx++)
            limited += (splitted[idx] + objectSeparator);

        // Remove trailing comma added inside for loop
        limited = limited.substring(0, limited.lastIndexOf(","));

        finalMap.put(e.getKey(), limited);
    }
    System.out.println("final map after limiting the data " + finalMap);
}