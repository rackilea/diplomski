Pattern p = Pattern.compile("^untitled(\\d+)[.]java$", Pattern.CASE_INSENSITIVE);
for (String fileName : fileNames) {
    Matcher m = p.matcher(fileName);
    if (!m.find()) {
        continue;
    }
    String digits = m.group(1);
    ... // Parse and find the max
}