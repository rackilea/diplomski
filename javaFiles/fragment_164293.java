Predicate<Group> matchingGroup = ...;
 Predicate<Type> matchingType = ...;

 Function<Group, Type> getType = new Function<Group, Type>(){};
 Function<Type, Item> getItem = new Function...;

 // starting point
 List<Group> myGroups;
 Iterable<Item> filteredItems =
    Iterables.transform(
       Iterables.filter( 
          Iterables.transform(
              Iterables.filter(myGroups, matchingGroup),
              getType),
          matchingType),
       getItem);