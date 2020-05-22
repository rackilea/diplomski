final Map<String, String> tokens = new HashMap<>();
    tokens.put(":asd:", "<img src=asd.gif>");
    tokens.put(":)", "<img src=sorriso.gif>");
    final String template = ":asd: bravo! :)";

    final String patternString = tokens.keySet()
        .stream().map(Pattern::quote).collect(Collectors.joining("|"));
    final Pattern pattern = Pattern.compile(patternString);
    final Matcher matcher = pattern.matcher(template);
    final StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
        matcher.appendReplacement(sb, tokens.get(matcher.group(0)));
    }
    matcher.appendTail(sb);
    System.out.println(sb.toString());