String input = "2x^3-3x^-2";
Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
Matcher m = p.matcher( input );
while (m.find()) {
    System.out.println("Coef: " + m.group(1));
    System.out.println("Degree: " + m.group(2));
}