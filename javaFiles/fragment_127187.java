String firstLine = scan.nextLine();
Pattern pattern = Pattern.compile("[a-zA-Z]{3}\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}");
Matcher matcher = pattern.matcher(firstLine);

if (matcher.find()) {
    String rebootTime = matcher.group();
}