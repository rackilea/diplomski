String in = "SPEEDWAY 3007906\n" +          
"Wallace NC 28466          \n" +
"TRAM: 1086244             \n" +
"9/17/2017  2:12 pm        \n" +
"Pump 08                   \n" +
"Regular Unleaded          \n" +
"8,716 @ $2,639/6131       \n" +
"GAS TOTAL           $23.00\n" +
"TAX                 $0.03 \n" +
"TOTAL               $23.80\n" +
"Uisa          ";

Pattern p = Pattern.compile("(?<=^TOTAL)\\s*(\\$\\s*\\d+\\.?\\d*)\\s*$", MULTILINE);
Matcher m = p.matcher(in);

if(m.find()) {
    System.out.println(m.group(1));
}