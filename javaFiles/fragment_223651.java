WootProductsService wootProductService; //Injected

public List<Woot> findAllWoots(final boolean isBuy) throws Exception {

    final List<Woot> allWoots = wootService.findAllWoots();

    return isBuy ? wootProductService.getWootsWithAvailableProducts(allWoots) : allWoots;
}