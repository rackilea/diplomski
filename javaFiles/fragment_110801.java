private static String ledgerString = "DIGITAL SPORTS$8.95HD AO$9.95UCC REC$1.28RENTAL FEE$7.00LOCAL FRANCHISE$4.67";
private static Pattern pattern1 = Pattern.compile("([a-zA-Z ]+)(\\$[0-9]*\\.[0-9][0-9])");
private static Matcher matcher = null;
public static void main(String[] args) {
    // TODO Auto-generated method stub
    matcher = pattern1.matcher(ledgerString.trim());

    while (matcher.find()) {

        System.out.println(matcher.group(1) + " " + matcher.group(2));
    } 

}