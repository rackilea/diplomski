Pattern p = Pattern.compile("(?<!\\d)\\d{2}:\\d{2}(?!\\d)");
Matcher m = pattern.matcher(inputString);

if (m.find()) {
    System.err.println("Time: " + m.group());
}