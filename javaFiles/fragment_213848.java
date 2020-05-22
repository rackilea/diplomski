String password = "-passw@rd";
// nice trick: by placing hyphen at the end of the character class,
// we don't need to escape it
String pattern = "^((?=[A-Za-z0-9@])(?![_\\\\-]).)*$";
if (password.matches(pattern)) {
    System.out.println("valid");
}
else {
    System.out.println("not valid");
}