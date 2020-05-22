List<MyObject> custom = /* snip */;
List<MyObject> reference = /* snip */;

Set<MyObject> uniques = new LinkedHashSet<>(custom.size() + reference.size());
uniques.addAll(custom);
uniques.addAll(reference);
List<MyObject> deduped = new ArrayList<>(uniques);