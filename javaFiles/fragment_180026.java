String a = "dfdf4932fef84835fea";
Pattern pattern = Pattern.compile("^([A-Za-z]|[0-9])+$");
Matcher matcher = pattern.matcher(a);

if (matcher.find()) {
    // it's ok
}