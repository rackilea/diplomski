public List<CalculatedItemCostPerStore> getCalcualtedItemCostPerStore() {
    return item
        .getQuantities().stream().map(quantities -> {
          Store.StoreCosts<CostType, BigDecimal> storeCosts = quantities.getStore().getStoreCosts();
          return new CalculatedItemCostPerStore(quantities.getStore().getName(), new TreeSet<>(quantities
              .getItemCostEvents()
              .stream()
              .map(e -> new CalculatedItemCost(e.getCostTrigger(), e.getTriggerQuantity().multiply(storeCosts.get(e.getCostTrigger()))))
              .collect(
                  Collectors.toMap(CalculatedItemCost::getCostType, Function.identity(), (a, b) -> new CalculatedItemCost(a.getCostType(), a.getCost().add(b.getCost())))
              ).values()));
        })
        .collect(Collectors.groupingBy(CalculatedItemCostPerStore::getStore))
        .values()
        .stream()
        .flatMap(Collection::stream).collect(Collectors.toList())
        ;
  }