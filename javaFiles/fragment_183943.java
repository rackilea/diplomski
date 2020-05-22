Iterator<String> it = name.iterator();
String previousName = "";

while (it.hasNext()) {
    String currentName = it.next();
    if (currentName.equals(previousName)) {
        it.remove();
    }
    previousName = currentName;
}