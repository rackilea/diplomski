public static PaymentType parse(String type) {
    for (PaymentType paymentType : PaymentType.values()) {
        if (paymentType.getType().equals(type)) {
            return paymentType;
        }
    }
    return null; //or you can throw exception
}