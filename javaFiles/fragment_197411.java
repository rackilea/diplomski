List<String> tokens = new ArrayList<>();
Pattern p = Pattern.compile("(\\d+(\\.\\d+)?)|[a-zA-Z]+|[()^*/+-]");
Matcher m = p.matcher("exp(42) * x^(24-3x) - 3.14");
while (m.find()) {
    tokens.add(m.group());
}