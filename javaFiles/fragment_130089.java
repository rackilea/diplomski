HashMap<String, Integer> val = normal_idx.get(docID);
if (val == null) {
    val = new HashMap<String, Integer>();
    normal_idx.put(docID, val);
}

Integer count = val.get(token);
if (count == null) {
    val.put(token, 1);
} else {
    val.put(token, count + 1);
}