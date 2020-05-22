while (m.find()) {
    if(last_match != m.start())
        splitted.add(text.substring(last_match,m.start()));
    splitted.add(m.group());
    last_match = m.end();
}
if(last_match != text.length())
    splitted.add(text.substring(last_match));