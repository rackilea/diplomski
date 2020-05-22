String str = "Message:id1:[label1:label2:labelN]:id2:[label1:label2:labelM]:id3:[label1:label2:labelK]";
Pattern p = Pattern.compile("([^:]+):\\[([^\\]]+)\\]");
Matcher m = p.matcher(str.substring(8));
Map<String, List<String>> idmap = new HashMap<String, List<String>>(); 
while (m.find()) {
    List<String> l = new ArrayList<String>();
    String[] tok = m.group(2).split(":");
    for (String t: tok)
        l.add(t);
    idmap.put(m.group(1), l);
}
System.out.printf("IdMap %s%n", idmap);