public class MultipleAddOperation implements BaseOperation<Integer> {
  private int sum ;

  public MultipleAddOperation(int requiredInt){
    sum = requiredInt;
  }

  public void add(int optionalInt){
    sum += optionalInt ;
    return this;
  }

  @Override
  public Integer execute(){
    return sum;
  }
}