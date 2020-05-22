private static Collection<Product> listProducts(List<Sets> sets) {
    Map<String, Product> uniques = new HashMap<>();
    for (Sets set : sets)
        for (Product p : asList(set.item1, set.item2, set.item3))
            uniques.merge(p.name, p, (a, b) -> a.merge(b));
    return uniques.values();
}