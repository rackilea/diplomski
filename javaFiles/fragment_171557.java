private static Collection<Product> listProducts(List<Set<Product>> sets) {
    Map<String, Product> uniques = new HashMap<>();
    for(Set<Product> set : sets)
        for(Product p : set)
            uniques.merge(p.name, p, (a, b) -> a.merge(b));
    return uniques.values();
}