public void pay(View view){
    PayPalPayment payment = new PayPalPayment(new BigDecimal(10), "USD", "Test payment with paypal",
            PayPalPayment.PAYMENT_INTENT_SALE); 

    Intent intent = new Intent(this, PaymentActivity.class);
    intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
    intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
    startActivityForResult(intent, m_paypalRequestCode);
}