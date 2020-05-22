public void decrement(double valToDecrementBy) {
  double work = this.value.doubleValue();
  work -= valToDecrementBy;
  // should use some value related to incrementing amount
  if ((this.value.doubleValue() - this.lowValue.doubleValue()) < 0.1D) {
     work = ((this.value.doubleValue() + this.highValue.doubleValue() + 1) - this.lowValue.doubleValue());
  }
  // ... no way to put it back
}