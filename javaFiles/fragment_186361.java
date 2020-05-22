Map<String, Set<String>> resultSet = 
        products.stream()
                .collect(groupingBy(Product::getName,
                        mapping(Product::getReviews,
                                flatMapping(Collection::stream,
                                        toSet()))));