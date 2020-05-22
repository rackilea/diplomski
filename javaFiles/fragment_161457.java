String sub = ...;
ObservableList<Part> full = ...;
FilteredList<Part> filtered = full.filtered(part -> part.getPartName().contains(sub));
// or use new FilteredList<>(...);

// Then, to "re-search" the list...
String newSub = ...;
filtered.setPredicate(part -> part.getPartName().contains(newSub));