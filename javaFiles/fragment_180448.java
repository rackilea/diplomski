String subjectCode = "02 credits between ----";
String regex1 = "(\\d+).*credits between --+.*";
Pattern p1 = Pattern.compile(regex1);
Matcher m = p1.matcher(subjectCode);
if (m.matches()) {
    Integer subjectCredits = Integer.valueOf(m.group(1));
    System.out.println("Subject Credits: " + subjectCredits);
}