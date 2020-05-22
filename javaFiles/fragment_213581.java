Map<Long, List<Widget>> map =
    widgets.stream()
           .flatMap(w -> w.getStocks().stream().map(s -> new AbstractMap.SimpleEntry<>(s, w)))
           .filter(e -> warehouseIds.contains(e.getKey().getWarehouseId()))
           .collect(Collectors.groupingBy(
              e -> e.getKey().getWarehouseId(),
              minAll(
                Comparator.comparingInt(e -> e.getKey().getQuantity()), 
                Collectors.mapping(e -> e.getValue(), Collectors.toList())
              )
           ));