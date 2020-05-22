return skuListEntityList.stream()
    .filter(x -> x.getStatusTypDbky().getTypDbkey().equals(SkuListStatus.ACTIVE.getId()))
    .map(x -> x.getSkuListLineItems())
    .flatMap(x -> x.stream()
        .filter(s -> s.getStatusTypDbky().getTypDbkey().equals(SkuListLineItemStatus.ACTIVE.getId())))
    .map(x -> x.getSkuListEntity())//remove and simply operate on x below
    .collect(Collectors.toList())//This is not needed as you're already working with a stream
    .stream()//This is not needed as you're already working with a stream
    .map(x -> skuListMapper.toSkuListResource(x/*x.getSkuListEntity() remove map above*/)).collect(Collectors.toList());