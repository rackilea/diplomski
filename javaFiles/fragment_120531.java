ProductTO newProd = 
    ProductEntryHandler.getInstance().prepareProductsForInvoice());
invoiceForm.setProducts(new ArrayList<ProductTO>());
invoiceForm.getProducts().add(newProd);

invoiceForm.setProductList(new ArrayList<ProductTO>());
invoiceForm.getProductList().add(newProd);