public CircleCarpet(String ID, double priceOf, int rad){
    super(ID, priceOf)
    radius = rad;
    super.unitPrice = priceOf;
    computeTotalPrice();

}