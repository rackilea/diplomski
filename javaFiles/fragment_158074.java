String[] words = ...;
StringBuilder expr = new StringBuilder();
for (String word : words) {
    if (expr.length() != 0)
        expr.append("|"):
    expr.append(word);
}
i = i.replaceAll("\\b(" + expr + ")\\b", "bla");