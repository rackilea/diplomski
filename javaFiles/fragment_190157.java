Map<String, String[]> mp1 = //
Map<String, String[]> mp2 = //
Map<String, List<String>> res = new HashMap<>();
for (String key : mp1.keySet()) {
    int val1 = Integer.valueOf(mp1.get(key)[1]);
    int val2 = Integer.valueOf(mp2.get(key)[1]);
    List<String> resVal = new ArrayList<>();
    resVal.add(mp1.get(key)[0]);
    resVal.add(String.valueOf(val1-val2));
    res.put(key, resVal);
}
return res;