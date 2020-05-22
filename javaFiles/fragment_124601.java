List<Product> products = null;
    try {
        ProductPageFilter pageFilter = PageFilterFactory.getAllRows(ProductColumn.Product_ID);
        products = ProductApi.getProducts(pageFilter);
    } catch (SdkFault e) {
        System.err.println("getProducts() failed: " + e.getMessage());
        throw new RuntimeException(e);
    }
    if (products == null || products.size() == 0) {
        System.out.println("No Products assigned to user '" + username + "'");
    } else {
        for (Product product : products) {
            productName = product.getName();
            productId = product.getproductId();
            List<AttachComponent> attachComponents = null;
            try {
                attachComponents = AttachApi.getAttachComponents(productId);
            } catch (SdkFault e) {
                System.err.println("AttachApi.getAttachComponents() failed");
                throw new RuntimeException(e);
            }
            for (AttachComponent attachComponent : attachComponents) {
                attach = attachComponent.getComponentName();
                System.out.println("ProductName: " + productName + " ID: " + productId + " Attach: " + attach);
            }
        }
    }