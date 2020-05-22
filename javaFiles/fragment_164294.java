// starting point
 List<Group> myGroups;
 Iterable<Type> types = Iterables.transform(
              Iterables.filter(myGroups, matchingGroup),
              getType);
 Iterable<Item> items = Iterables.transform(
              Iterables.filter(types, matchingType),
              getItem);