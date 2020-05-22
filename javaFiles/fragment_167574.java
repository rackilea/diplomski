private String getProfileName(String path) {
    Pattern pattern = Pattern.compile("^[^1-9]*");
    Matcher matcher = pattern.matcher(path);
    matcher.find();
    return matcher.group();
}