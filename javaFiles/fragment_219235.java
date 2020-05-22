if (value != null) {
    value = value.trim();
    this.value = value.length() == 0 ? BigDecimal.ZERO : new BigDecimal(value);
} else {
    this.value = BigDecimal.ZERO;
}