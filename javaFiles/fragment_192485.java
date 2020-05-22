String number = "(514)985-6586";
String pattern = "\\d{10}|\\(\\d{3}\\)\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
if (number.matches(pattern)) {
    System.out.println("MATCH");
}
else {
    System.out.println("NO MATCH");
}