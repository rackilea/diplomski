TregexPattern tgrepPattern = TregexPattern.compile("PRP");
TregexMatcher m = tgrepPattern.matcher(t);
while (m.find()) {
    Tree subtree = m.getMatch();
    pronouns.add(subtree);
}