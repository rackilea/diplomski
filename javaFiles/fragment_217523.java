public class MovingAverage {
  private final BigDecimal[] window;
  private final int period;
  private int size;
  private int idx;
  private BigDecimal sum = BigDecimal.ZERO;

  public MovingAverage(int period) {
    this.period = period;
    window = new BigDecimal[period];
  }

  public void add(BigDecimal num) {    
    if(size < period)
      size += 1;
    else 
      sum = sum.subtract(window[idx]);

    sum = sum.add(num);
    window[idx++] = num;
    if(idx == period) idx = 0;
  }

  public BigDecimal getAverage() {
    if (size == 0)
      return BigDecimal.ZERO;
    BigDecimal divisor = BigDecimal.valueOf(size);
    return sum.divide(divisor, 2, RoundingMode.HALF_UP);
  }  
}