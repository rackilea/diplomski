ArrayList<String> elements = new ArrayList<String>();

Elements e = doc.select("span");

for (int i = 0; i < e.size(); i++) {
    elements.add(e.get(i).html());
}