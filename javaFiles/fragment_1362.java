SparseArray<List<String>> sparseArray = new SparseArray<List<String>>();
String str;
while ((str = stream.readLine()) != null) {
    char c = str.charAt(0);
    // get or create list stored at letter c
    List<String> list = sparseArray.get(c);
    if (list == null) {
        list = new ArrayList<String>();
        sparseArray.put(c, list);
    }
    // add word to list
    list.add(str);
}