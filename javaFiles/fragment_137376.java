Map<String, Long> countByCost = productList.stream()
                .collect(Collectors.groupingBy(costRange, TreeMap::new, Collectors.counting()));

Function<Product, String> costRange = ele -> {
        if(ele.cost >= 1 && ele.cost < 11)
            return "1-10";
        if(ele.cost >= 11 && ele.cost < 101)
            return "11-100";
        if(ele.cost >= 101 && ele.cost < 1001)
            return "101-1000";
        return "others";
 };