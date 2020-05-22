List<String> chunks = new ArrayList<>();
Matcher m = Pattern.compile("(([^\\s,]+)((\\s*)=(\\s*)\"([^\"]+)\"))")
     .matcher("shape=\"box\", fontsize = \"130\"fontstyle= \" ITALIC \" fillcolor=\"red\";");
while (m.find()) {
     chunks.add(m.group());
}