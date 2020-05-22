final Pattern pattern = Pattern.compile(".*?(M+).*?");
final String string = "somerandoMMMstring";
final Matcher m = pattern.matcher(string);
if (m.find()) {
    System.out.println(m.group(1));
}