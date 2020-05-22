String testString = "Remove this (ACTDIK002), ACTDIK002, (L1:3.CI), 9-12.CT.d.12, and 1A-CS-01 " 
        + "but not (DLCS), 781-338-3000, (DTC), (200), K-12, K or 12. " 
        + "Also not (), A.I., AI, A or a. . ...";
System.out.println(testString);
String regex = "(?i)(?=[\\dA-Z\\(\\)\\.:-]*\\d)(?=[\\dA-Z\\(\\)\\.:-]*[A-Z])[\\dA-Z\\(\\)\\.:-]{5,}";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(testString);
testString = matcher.replaceAll("");
System.out.println(testString);
//Clean-up extra spaces and unneeded commas
//testString = testString.replaceAll("\\s{2,}", " ").replaceAll("(\\s\\.)|(\\s\\,)", "");
testString = testString.replaceAll("[ ]{2,}", " ").replaceAll("([ ]\\.)|([ ]\\,)", "");
System.out.println(testString);