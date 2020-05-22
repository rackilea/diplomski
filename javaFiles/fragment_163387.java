List<PurchaseItemCancellation> = cancellations.stream()
    .filter(c -> c != null)
    .map(PurchaseCancellation::getPurchaseItemCancellations)
    .filter(l -> l != null)
    .flatMap(List::stream)
    .collect(Collectors.groupingBy(PurchaseItemCancellation::getId,
        Collectors.reducing(BigDecimal.ZERO, PurchaseItemCancellation::getQuantity, BigDecimal::add)))
    .entrySet().stream()
    .map(e -> new PurchaseItemCancellation(e.getKey(), e.getValue()))
    .collect(Collectors.toList());