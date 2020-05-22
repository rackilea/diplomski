StringBuffer buffer = new StringBuffer();
while (matcher.find()) {
    matcher.appendReplacement(buffer, replace);
    cnt++;
}
buffer.append(line.substring(matcher.end()));
// "buffer" contains the string after the replacement