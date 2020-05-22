public String toString() {
    return "Product: "+ this.productName + ", Barcode: " + this.barCode
            + ", Expiration Date: " + this.expirationDate.toString() + ", Customer Price: "
            + this.customerPrice + ", Shops Price: " + this.shopsPrice
            + ", Instore Amount: " + this.inStoreAmount + ", Sale: "+ ((this.sale == null) ? "Not on sale" : this.sale.toString());
}