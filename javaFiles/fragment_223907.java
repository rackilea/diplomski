public double getTotalCost() {
    double total = 0;
    for (ItemPrice ip : itemlist) {
        total += ip.getCost();
    }
    return total;
}