// Summarize
EnumMap<PaymentType, Double> totals = new EnumMap<>(PaymentType.class);
for (Payment payment : payments) {
    Double total = totals.get(payment.getType());
    total = (total == null ? payment.getAmount() : total.doubleValue() + payment.getAmount());
    totals.put(payment.getType(), total);
}

// Without autoboxing
    total = Double.valueOf(total == null ? payment.getAmount() : total.doubleValue() + payment.getAmount());

// Get total
Double totalObj = totals.get(PaymentType.CASH);
double cashTotal = (totalObj != null ? totalObj.doubleValue() : 0d);