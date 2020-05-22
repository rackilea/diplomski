public class BookCreationRequest {
    private ShippingAddress shippingAddress;
    private CreditCredit creditCard;

    public ShippingAddress  getShippingAddress() {...}
    public CreditCard       getCreditCard() {...}

    public BookCreationRequest(ShippingAddress shippingAddress, CreditCard creditCard) {
        this.creditCard = creditCard;
        this.shippingAddress = shippingAddress;
}