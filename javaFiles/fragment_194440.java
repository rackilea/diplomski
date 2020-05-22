IntStream.range(0, rules.size())
            .boxed()
            .flatMap(x -> products.stream()
                    .filter(p -> rules.get(x).getProductsToApply().contains(p.getClass()))
                    .map(y -> new AbstractMap.SimpleEntry<>(x, y)))
            .map(e -> new ConcreteProductDecorator(e.getValue(), rules.get(e.getKey()), conditions.get(e.getKey())))
            .collect(Collectors.toList());