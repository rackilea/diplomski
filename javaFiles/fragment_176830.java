str = str.replaceAll("<[^<]*?>|^\\{|\\}$", "");
Matcher m = Pattern.compile(":(\\S+)").matcher(str);
List<String> lst = new ArrayList<>();
while (m.find()) {
    lst.add(m.group(1));
}