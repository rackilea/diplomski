String card = ClientCardDetails.encryptCardDetails(
    debitCardNumber,
    debitcardCVV,
    debitcardExpiryDate,
    AdminKeyGenerator.generateKey()
);