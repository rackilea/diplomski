List l = parcels.stream()
         .collect(Collectors.groupingBy(p -> p.getPostalCode()))
         .entrySet()
         .stream()
         .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
         .limit(N) //Top N
         .collect(Collectors.toList());