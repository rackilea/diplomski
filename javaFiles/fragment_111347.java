String documentname = obj.get("name").toString();
List<String> paths = new ArrayList<String>();
//if key already exists append new path to the value
if (map.containsKey(documentname)) {
    paths = map.get(documentname);
}
paths.add(tfile.getAbsolutePath());
map.put(documentname, paths);