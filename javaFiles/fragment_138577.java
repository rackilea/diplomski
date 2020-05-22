Pattern pattern = Pattern.compile("\\du\\d\\d{0,1}_x(32|64)");
Matcher matcher = pattern.matcher("windows_6u31_x32.jar");
// executing matcher
if (matcher.find()) {
    System.out.println(matcher.group(0));
}