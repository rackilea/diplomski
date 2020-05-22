List<Map<String, Object>> values = null;
Map<String, Object> prev = null;
for (Map<String, Object> cur: data1) {
    if (prev == null || !prev.get("siteId").equals(cur.get("siteId"))) {
        Map<String,Object> obj = new HashMap<>();
        values = new ArrayList<>();
        obj.put("siteId", cur.get("siteId"));
        obj.put("siteName", cur.get("siteName"));
        obj.put("values", values);
        data2.add(obj);
    }
    values.add(cur);
    prev = cur;
}