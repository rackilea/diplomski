Pattern pattern = Pattern.compile("^(\\d{2,3})[.,]?(\\d{3})[.,]?(\\d{2})$");
String replacement = "$1,$2.$3";

String[] samples = {"14.978.00", "14,97800", "14.97800", "14,978.00"};
for (String sample : samples) {
    Matcher matcher = pattern.matcher(sample);
    System.out.println(sample + "\t= " + matcher.replaceAll(replacement));
}