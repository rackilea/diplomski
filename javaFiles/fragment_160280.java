public static final Pattern reAbsInnerXPath = Pattern.compile(
        "(^|[\\(\\[\\|,])\\s*/"); //TODO: avoid matches inside strings

protected String fixAbsoluteXPaths(String xpath) {
    Matcher m = reAbsInnerXPath.matcher(xpath);
    return m.replaceAll("$1\\$__root/");
}