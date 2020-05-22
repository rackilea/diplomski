List<String> nonBlank = new ArrayList<String>();
for(String s: str) {
    if (!s.trim().isEmpty()) {
        nonBlank.add(s);
    }
}
// nonBlank will have all the elements which contain some characters.
String[] strArr = (String[]) nonBlank.toArray( new String[nonBlank.size()] );