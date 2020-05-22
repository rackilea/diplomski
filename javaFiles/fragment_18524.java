List<String> strings = new ArrayList<String>();
int index = 0;
while (index < text.length()) {
    strings.add(text.substring(index, Math.min(index + 4,text.length())));
    index += 4;
}