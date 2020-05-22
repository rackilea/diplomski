public double getPriceDiscountedBy(double disc) {
    return price*(1.0-disc);
}

public double getPriceDiscountedTo(double disc) {
    return price*disc;
}