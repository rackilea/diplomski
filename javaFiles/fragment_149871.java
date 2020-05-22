final String mcontentURI[] = new String[count];
final Pattern p = Pattern.compile("src=\"(.*?)\"");
for (int i = 0; i < count; i++) {
    Matcher m = p.matcher(content_val); // Use different strings here
    if (m.find()) {
        mcontentURI[i] = m.group(1);
    }
}