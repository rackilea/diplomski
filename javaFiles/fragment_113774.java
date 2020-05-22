String s = "abc____2019____5_10_40_56_20190319213500.pdf";
Pattern p = Pattern.compile("\\d+\\D*$");
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group());
} else {
    System.out.println("Didn't find");
}