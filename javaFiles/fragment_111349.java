String documentname = obj.get("name").toString();
List<String> paths = map.get(documentname);
if (paths == null) {
   paths = Collections.synchronizedList(new ArrayList<String>());
   List<String> existing = map.putIfAbsent(documentname, paths);
   if (existing != null) {
       paths = existing;
   }
   paths.add(tfile.getAbsolutePath());
}