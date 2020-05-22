EnumMap<PaymentType, BigDecimal> totals = new EnumMap<>(PaymentType.class);
for (Payment payment : payments) {
    BigDecimal total = totals.get(payment.getType());
    total = (total == null ? payment.getAmount() : total.add(payment.getAmount()));
    totals.put(payment.getType(), total);
}