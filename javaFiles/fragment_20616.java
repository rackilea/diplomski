// list contains [1, 2, 3, 4, 2, 3, 2]

Set<Integer> set = new HashSet<>();

for (Integer i : list) {
    if (set.contains(i)) {
        set.remove(i);
    } else {
        set.add(i);
    }
}

list.clear();
list.addAll(set);
System.out.println(list); // [1, 2, 4]