List<MyObject> custom = /* snip */;
List<MyObject> reference = /* snip */;

Set<Decorator> uniques = new LinkedHashSet<>(custom.size() + reference.size());
for (MyObject m : custom) uniques.add(new Decorator(m));
for (MyObject m : reference) uniques.add(new Decorator(m));

List<MyObject> deduped = new ArrayList<>(uniques.size());
for (Decorator d : uniques) deduped.add(d.getValue());