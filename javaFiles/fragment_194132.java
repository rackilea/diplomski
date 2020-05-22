String input = "trjb....fsf..ib.bi.";
Pattern pattern = Pattern.compile("[^\\.]\\.([^\\.]|$)");
Matcher matcher = pattern.matcher(" " + input);
while (matcher.find()) {
    System.out.println(matcher.start());
}