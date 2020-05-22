Iterator<String> i=story.iterator();
while (i.hasNext()) {
    String check = i.next();
    if (check.equals(stringToReplace)) {
        i.set(getRandomAdjective());
    }
}