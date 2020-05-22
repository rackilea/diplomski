String documentname = obj.get("name").toString();
List<String> paths = Collections.synchronizedList(new ArrayList<String>());
List<String> existing = map.putIfAbsent(documentname, paths);
if (existing != null) {
    paths = existing;
}
paths.add(tfile.getAbsolutePath());