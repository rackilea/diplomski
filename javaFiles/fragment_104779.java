private static Pattern PARM_PATTERN = Pattern.compile("(\\[*(?:[ZCBSIJFD]|(?:L[^;]+;)))");

private static List<String> parseSignature(String signature) {
    List<String> parms = new ArrayList<>();

    int openParenPos = signature.indexOf('(');
    int closeParenPos = signature.indexOf(')', openParenPos+1);

    String args = signature.substring(openParenPos + 1, closeParenPos);
    if (!args.isEmpty()) {
        Matcher m = PARM_PATTERN.matcher(args);
        while (m.find()) {
            parms.add(m.group(1));
        }
    }

    return parms;
}