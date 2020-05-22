public static void main(String[] args) {
    String textToParse = "TdkRoot(0x0)/Tdk(0x2,0x0)/Tdk(0x0,0x1)/VAL(40A8F0B32240,2x4)/SN(0000:0000:0000:0000:0000:0000:0000:0000)/IP(000.1.000.1)/Blue(2x4,2x4)";
    Pattern p = Pattern.compile("(\\w+)\\((.*?)\\)");
    Matcher m = p.matcher(textToParse);
    while (m.find()) {
        System.out.println("key :" + m.group(1));
        if (m.group(2).contains(",")) {
            String[] s = m.group(2).split(",");
            System.out.println("values : " + Arrays.toString(s));
        } else {
            System.out.println("value :" + m.group(2));
        }

    }
}