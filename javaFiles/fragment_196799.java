LinkedHashSet<Integer> set = new LinkedHashSet<>();
HashSet<Integer> alreadyPresent = new HashSet<>();
for (Integer i : intArray) {
  if (!set.add(i)) {
    alreadyPresent.add(i);
  }
}
set.removeAll(alreadyPresent);

ArrayList<Integer> list = new ArrayList<>(set);