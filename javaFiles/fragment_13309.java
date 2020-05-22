String line = "000 1 This is my message";
Pattern p = Pattern.compile("\\p{L}");
Matcher m = p.matcher(line);
if (m.find()) {
    System.out.println(m.start());
}