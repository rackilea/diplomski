String s = "Your OTP verification code is 5M67BX";  
String s2 = "Your updated OTP code is YW32R2 for phone verification";

Pattern p = Pattern.compile("([A-Z0-9]){6}");
Matcher m = p.matcher(s);
if (m.find()) {
    System.out.println(m.group());
}
m = p.matcher(s2);
if (m.find()) {
    System.out.println(m.group());
}