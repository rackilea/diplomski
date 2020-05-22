Map<Integer, Product> productById =
        products.stream()
                .collect(Collectors.toMap(Product::getId, Function.identity()));

List<SoldProduct> soldProducts =
        dto.getProducts()
           .stream()
           .filter(d -> productById.containsKey(d.getIdProduct()))
           .map(d -> new SoldProduct(productById.get(d.getIdProduct()), d.getSerialList()))
           .collect(Collectors.toList());