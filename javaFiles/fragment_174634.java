public class ConditionOperand<T extends Comparable<?>> implements Comparable<ConditionOperand<T>> {
  T parsedNumber; 
  public ConditionOperand<T> parse(String aString) {
    if(!StringUtils.isEmpty(aString)) {
      parsedNumber = simpleParse(aString);
    }
    return this;
  }

  public int compareTo(ConditionOperand arg) {
    T someArg = arg.getWrappedToken();
    return parsedNumber.compareTo(someArg);
  }

  public T getWrappedToken() {
    return this.parsedNumber;
  }

  public abstract T simpleParse(String s);
}