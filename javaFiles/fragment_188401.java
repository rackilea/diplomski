StringBuffer sb = new StringBuffer();
while (m.find()) {
    prefix = "<TAG_" + i + ">";
    m.appendReplacement(sb, prefix + m.group() + suffix);
    i++;
}
m.appendTail(sb); // append the rest of the contents