String str = "-2.100 CM 1.000 CM 1.025 CM";

Pattern p = Pattern.compile("[+-]?\\d+\\.?\\d*(?= CM)", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(str);
while (m.find()) {
    System.out.println(new Double(m.group()));
}