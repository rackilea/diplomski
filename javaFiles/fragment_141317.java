String rx = "(?i)w(?:e{2})?k\\s*(\\d+)(?: +(\\d{4})\\b)?(?:(?:\\s*(?:until|tm)\\s*|[ _/])(?:w(?:e{2})?k)?(\\d+)(?: +(\\d{4})\\b)?)?"; 
String s = "wk 1 2016\n(wk 47 2015 tm 9 2016)\nSoccer International wk43\nNational Geopgraphic (wk50)\nSchoolpaper wk39/wk43\nSome magazine week12 until 16\nAnother magazine wk36_38\nAnother magazine wk36_wk38"; 
StringBuffer result = new StringBuffer(); // week 47 (2015) - week 9 (2016)  
Matcher m = Pattern.compile(rx).matcher(s); // week 1 (2016)
while (m.find()) {
    String replacement = "";
    String prt1 = ""; String prt2 = "";
    if (m.group(2) != null) {
        prt1 += " (" + m.group(2) + ")";
    }
    if (m.group(4) != null) {
        prt2 += " (" + m.group(4) + ")";
    }

    if (m.group(3) == null) {
        replacement = "week " + m.group(1) + prt1;
    } else {
        replacement = "week " + m.group(1) + prt1 + " - week " + m.group(3) + prt2;
    }
    m.appendReplacement(result, replacement);
}
m.appendTail(result);
System.out.println(result.toString());