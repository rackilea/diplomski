String exp = "2x^3+4x^2+5x-42";
Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
Matcher matcher = pattern.matcher(exp);
int x=0;
while (matcher.find()) {
    x=x+1;
    System.out.println("Group "+x+": " + matcher.group(1));
}