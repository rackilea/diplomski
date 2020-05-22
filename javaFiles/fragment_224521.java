Map<String, Float> costs = new HashMap<>();
for (int i = 0; i < category.length; ++i) {
    Float initial = costs.get(category[i]);
    if (initial == null)
        initial = 0f;
    costs.put(category[i], initial + amount[i]);
}