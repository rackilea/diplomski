Map<Product, Map<Center, Value>> result = 
           given.entrySet()
                .stream()
                .flatMap(entry -> entry.getValue()
                        .entrySet().stream()
                        .map(e -> new Object() {
                            Center c = entry.getKey();
                            Product p = e.getKey();
                            Value v = e.getValue();
                        }))
                .collect(Collectors.groupingBy(o -> o.p, Collectors.toMap(o -> o.c, o -> o.v)));