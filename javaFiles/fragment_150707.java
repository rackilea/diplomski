Pattern p = Pattern.compile("\\$\\{.*?\\}");
while (true) {
    Matcher m = p.matcher(myVar);
    if (!m.find()) {
        break;
    }
    String variable = m.group();
    String rep = hash.get(variable);
    myVar = m.replaceFirst(rep);
}