Map<String, List<MyProduct>> result = new HashMap<>();
for (MyProduct p : productList) {
    List<MyProduct> list = result.get(p.getTitle());
    if (list == null) {
        list = new ArrayList<>();
        result.put(p.getTitle(), list);
    }
    list.add(p);
}