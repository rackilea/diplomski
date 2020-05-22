String source = "1.22-3";
Matcher m=Pattern.compile("[.-]").matcher(source);
ArrayList<String> elements=new ArrayList<>();
ArrayList<String> separators=new ArrayList<>();
int pos;
for(pos=0; m.find(); pos=m.end()) {
    elements.add(source.substring(pos, m.start()));
    separators.add(m.group());
}
elements.add(source.substring(pos));