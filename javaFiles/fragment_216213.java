// In your class somewhere:
static final BigDecimal INFINITE_BIG_DECIMAL = new BigDecimal(); // Value doesn't matter

// Then:
if (theBigDecimal == INFINITE_BIG_DECIMAL) {
    // It's infinity, deal with that
}
else {
    // It's finite, deal with that
}