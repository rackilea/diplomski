Map<String, Double> result = invoiceList.stream()
            .filter(e -> e.getPrice() * e.getQuantity() > 100)
            .sorted(Comparator.comparingDouble(e -> e.getPrice() * e.getQuantity()))
            .collect(Collectors.toMap(Invoice::getName,
                    e -> e.getPrice() * e.getQuantity(), 
                    (left, right) -> left,
                    LinkedHashMap::new));