@PostMapping("/book")
    public boolean buyBook(@RequestBody BookCreationRequest bookCreationRequest) {
        CreditCard creditCard = bookCreationRequest.getCreditCard();
        ShippingAddress shippingAddress = bookCreationRequest.getShippingAddress();
        ...
    }