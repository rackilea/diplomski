List<ProductItemQuantity> piqs = product.getProductItemQuantities();

    if (piqs != null) {
        List<ProductItemQuantity> piiList = new ArrayList<ProductItemQuantity>();
        for (ProductItemQuantity pii : piqs) {
            // Check for ID in here?
            ProductItemQuantity curPII = piqService.getOne(pii.getId());
            curPII.setCount(pii.getCount());
            piiList.add(curPII);
        }
        originalProduct.setProductItemQuantities(piiList);
    }