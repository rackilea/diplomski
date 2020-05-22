final String mcontentURI[] = new String[count];
final Pattern p = Pattern.compile("src=\"(.*?)\"");
Matcher m = p.matcher(content_val);
int i = 0;
while (i < count && m.find()) {
    mcontentURI[i++] = m.group(1);
}