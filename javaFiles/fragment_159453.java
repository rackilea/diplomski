static List<ShopOrderItem> groupByNameAndSumCount(List<ShopOrderItem>... orders) {
    List<ShopOrderItem> merged = new ArrayList<>();
    for (List<ShopOrderItem> order : orders) {
        merged.addAll(order);
    }

    // group all by name as this is our invariant
    HashMap<String, ShopOrderItem> grouped = new HashMap<>();
    for (ShopOrderItem item : merged) {
        String name = item.getName();
        if (grouped.containsKey(name)) {
            ShopOrderItem current = grouped.get(name);
            // sum count
            current.setCount(current.getCount() + item.getCount());
        } else {
            grouped.put(name, item);
        }
    }

    // reusing to reduce memory footprint
    merged.clear();

    // prepare result
    for (String key : grouped.keySet()) {
        merged.add(grouped.get(key));
    }
    return merged;
}