List<String> matchList = new ArrayList<String>();

Pattern p = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b");
Matcher m = p.matcher(s);
while (m.find()) {
    matchList.add(m.group());
}