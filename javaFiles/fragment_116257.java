public static void main (String[] args) throws java.lang.Exception
{

    String text    =
        "4000M WX MODTSRA CLD FEW 600FT BKN CB 2400FT BKN CB 2900FT T" + 
        " 21 DP 18 QNH 1010.7HPA MET QFE 1004.1HPA TREND TEMPO MOD TSRA";
        text = "1500M CLD BKN 700FT BKN 4600FT T 16 DP 17 QNH 1014.7HPA MET QFE 1004.1HPA TREND TEMPO MOD TSRA";

    String patternString = "BKN.*?\\s+(\\d+)FT";

    Pattern pattern = Pattern.compile(patternString);

    Matcher matcher = pattern.matcher(text);
    if(matcher.find()) {
        System.out.println(matcher.group(1));
    } else {
        System.out.println("nothing matched");
    }
}