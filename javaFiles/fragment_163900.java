List<String> thingsIHave = new ArrayList<>(25);
//...
List<String> thingsIWantToKeep = new ArrayList<>(25);
for (int index = 1; index < 24; index++) {
    thingsIWantToKeep.add(Integer.toString(index));
}
thingsIHave.retainAll(thingsIWantToKeep);