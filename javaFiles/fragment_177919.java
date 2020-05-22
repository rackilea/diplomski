final String regex = "(?=([a-zA-Z]{2}))";
final String string = "subhash chand\n"
        + "yobie chimwanachomama\n"
        + "riadh chaieb";

final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(string);

while (matcher.find()) {
    System.out.println(matcher.group(1));

}