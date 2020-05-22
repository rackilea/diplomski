String strings[] = {"A", "B", "C", "D", "E", "F"};
List<Group> groups = new ArrayList<Group>();
for (int order = 1; order <= strings.length/2; ++order) {
    List<Group> groups2 = getGroups(strings, order); 
    groups.addAll(groups2);
}