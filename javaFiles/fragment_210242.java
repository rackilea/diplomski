List<Stuff> l = new ArrayList<Stuff>();

// [...] populate l with Stuff here [...]

// partitioning:
List<List<Stuff>> ll = Lists.partition(l, 5);
// you now have a list containing sub-lists of at most 5 elements