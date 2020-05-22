String[] temp = line.split("\\|");
Map<String,String> attributes = new HashMap<String,String>();
for (String p : temp) {
    String[] key = p.split("\\=");
    if (key.length == 2) {
        attributes.put(key[0],key[1]);
    }
}