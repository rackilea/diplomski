private int value;
private int lowValue;
private int highValue;
private double incr;

public GenericRolloverCounter(T l_startValue, T l_highValue, T incrementAmount) {
    double incr = incrementAmount.doubleValue();
    this.lowValue = Math.round(l_startValue.doubleValue() / incr);
    this.highValue = Math.round(l_highValue.doubleValue() / incr);
    this.value = Math.round(l_startValue.doubleValue() / incr);
}

public void increment(int valToIncrementBy) {
  this.value += valToIncrementBy;
  if (this.value > this.highValue) {
     this.value = (this.lowValue + (this.value - (this.highValue + 1)));
  }
}

@Override
public String toString() {
  return String.valueOf(incr * this.value);
}