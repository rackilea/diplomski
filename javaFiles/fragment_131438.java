// Get first product
    Bundle arguments = getArguments();
    if (arguments != null) {
        Product product = (Product) arguments.getSerializable(KEY_PRODUCT);
        getProduct(product);
    }