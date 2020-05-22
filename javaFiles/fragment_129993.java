private static String getAppName(String jobName) {
    Matcher m = Pattern.compile("^[^_]*_([A-Z0-9_]{1,9})_").matcher(jobName);
    if (m.find())
        return m.group(1);
    return null;
}