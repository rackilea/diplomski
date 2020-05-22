String s = "Oh crap that sucks";
List<Integer> badWordIndices = List.of(3, 13);
for (Integer i : badWordIndices) {
    int indexOfNextSpace = s.indexOf(" ", i);
    s = s.substring(0, i) + "$$$$" + (indexOfNextSpace != -1 ? s.substring(indexOfNextSpace) : "");
}
System.out.println(s);