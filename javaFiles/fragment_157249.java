List<ProductTest> productTests = productRepository.getProductTest();
    Map<Long, ProductT> products = new HashMap<Long, ProductT>();
    for (ProductTest pt : productTests) {
        ProductT productT = products.get(pt.getId());
        if (productT == null) {
            productT = new ProductT(pt.getId(), pt.getNameEl(), new ArrayList<MediaT>());
            products.put(pt.getId(), productT);
        }
        MediaT mediaT = new MediaT(pt.getMediaId(), pt.getMultimediaPath());
        productT.getMediaList().add(mediaT);
    }
    return products.values();