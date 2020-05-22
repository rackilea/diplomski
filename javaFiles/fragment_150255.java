return skuListEntityList.stream()
                .filter(x -> x.getStatusTypDbky().getTypDbkey().equals(SkuListStatus.ACTIVE.getId()))
                .flatMap(x -> x.getSkuListLineItems().stream())
                .filter(s -> s.getStatusTypDbky().getTypDbkey().equals(SkuListLineItemStatus.ACTIVE.getId()))
                .map(x -> skuListMapper.toSkuListResource(x.getSkuListEntity()))
                .collect(Collectors.toList());