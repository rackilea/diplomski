Comparator<Employee> comparator = comparators.get(sortlist.get(0).getKey());
if (sortlist.get(0).getOrder().equals("DESC")) {
    comparator = comparator.reversed();
}
for(int i = 1 ; i < sortlist.size() ; i++) {
    if (sortlist.get(i).getOrder().equals("DESC")) {
        comparator = comparator.thenComparing(comparators.get(sortlist.get(i).getKey()).reversed());
    } else {
        comparator = comparator.thenComparing(comparators.get(sortlist.get(i).getKey()));
    }
}
// now you can sort with "comparator".