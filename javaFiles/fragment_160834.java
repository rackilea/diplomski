String[] disjunctedPredicateGroups = query.split("\|");
List<String[]> normalizedPredicates = ArrayList<String[]>;
for (String conjunction : disjunctedPredicateGroups ) {
   normalizedPredicates.add(conjunction.split("\[|\]"));
}
// process each predicate