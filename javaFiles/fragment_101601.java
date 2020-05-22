private static ParameterizedQuery parse(String query) {
    List<Parameter> parms = new ArrayList<>();
    Matcher matcher = CONST_PATTERN.matcher(query);
    int start = 0;
    StringBuilder buf = new StringBuilder();
    while (matcher.find()) {
        int pos = matcher.start();
        buf.append(query, start, pos)
                .append(matcher.group(1))
                .append("?");
        parms.add(new Parameter(buf.length()-1,matcher.group(2)));
        start = matcher.end();
    }
    buf.append(query, start, query.length());
    return new ParameterizedQuery(
            buf.toString(), parms.toArray(new Parameter[parms.size()]));
}