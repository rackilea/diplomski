Set<Group> inGroupsSet = new HashSet<Group>();
// load inGroups into a set
for (Group group : inGroups)
    inGroupsSet.add(group);
// look up each Group in theGroups in the set
for (int g = 0; g < theGroups.length; g++)
    if (inGroupsSet.contains(theGroups[g]))
        gLV.setItemChecked(g, true);