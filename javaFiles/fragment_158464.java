Matcher m = p.matcher(data);
int prev = 1;
while (m.find()) {
  sb.append(data, prev, m.start());
  sb.append(replacements.get(m.group()));
  prev = m.end();
}
sb.append(data, prev, data.length() - 1);