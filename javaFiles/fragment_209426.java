public void discountBy(double disc) {
    price *= 1.0 - disc;
}
// or like this:
public void discountTo(double disc) {
    price *= disc;
}
// or both...