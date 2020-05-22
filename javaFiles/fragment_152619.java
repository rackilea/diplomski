Pair<BigDecimal, BigDecimal> totalMktTrade = subAccounts.parallelStream()
        .flatMap(ts -> ts.getAssets().parallelStream())
        .filter(ast -> !ast.getAssetTypeCode().equals(AssetType.CURRENCY))
         .map(ast -> Pair.of(ast.getPostMktVal(), ast.getTradeVal()))
        .reduce((a,b) -> Pair.of(a.getLeft().add(b.getLeft(), a.getRight().add(b.getRight());
BigDecimal totalMkt = totalMktTrade.getLeft();
BigDecimal totalTradeVal = totalMktTrade.getRight();