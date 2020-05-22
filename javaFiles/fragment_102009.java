Map<String, Double> result =
                invoiceList.stream()
                        .collect(groupingBy(Invoice::getName,
                                Collectors.summingDouble(e -> e.getPrice() * e.getQuantity())))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue() > 100)
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey,
                                Map.Entry::getValue, (left, right) -> left,
                                LinkedHashMap::new));