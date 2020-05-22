private double value;
private double lowValue;
private double highValue;

public GenericRolloverCounter(T l_startValue, T l_highValue) {
    this.lowValue = l_startValue.doubleValue();
    this.highValue = l_highValue.doubleValue();
    this.value = l_startValue.doubleValue();
}