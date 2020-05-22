private Rules rules;

@PostConstruct public void init() {
    InputStream io = splitRule.getInputStream();
    rules = splitRuleParser.parse(io);
}

public Rules getSplitRule() throws IOException {
    return rules;
}