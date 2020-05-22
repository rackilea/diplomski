final Pattern inputPattern = Pattern.compile("^(?<gameName>[^:]++):(?<score>\\d++):(?<time>\\d++)$")
final String line = sc.nextLine();
final Matcher matcher = inputPattern.matcher(line);
if(!matcher.matches()) {
    throw new IllegalArgumentException("Invalid input") //or whatever
}
final String gameName = matcher.group("gameName");
final int score = Integer.parseInt(matcher.group("score"));
final int time = Integer.parseInt(matcher.group("time"));