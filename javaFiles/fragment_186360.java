Map<String, Set<String>> resultSet = 
        products.stream()
                .collect(toMap(Product::getName,
                        p -> new HashSet<>(p.getReviews()),
                        (l, r) -> {
                            l.addAll(r);
                            return l;
                        }));