void addInvoiceItem(Item item, Integer quantity, double discount) {
    if(
        item == null || 
        quantity == null || 
        item.sku == null ||
        item.description == null
    ) {
        throw new NullPointerException();
    }
    InvoiceItem invoice = new InvoiceItem(item, quantity, discount);
    invoiceList.add(invoice);
}