public double gettotaldiscount() {
    if (order >= bulkOrderQuantity) {
        return order * cost * discount / 100;
    } else {
        return 0;
    }
}