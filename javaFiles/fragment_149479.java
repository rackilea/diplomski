public class NumberList {
  private double[] numbers;
  private String key;

  public NumberList(Strig key, double[] numbers){
    this.ley = key;
    this.numbers = numbers;
  }

  public NumberList(String[] inputList) {
    key = inputList[0];
    numbers = new double[inputList.length-1];
    for(int i=1;i<inputList.length;i++){
      numers[i-1] = Double.parseDouble(inputList[i]);
    }
  }

  public String getKey() {
    return key;
  }

  public double[] getNumbers() { 
    return numbers;
  }
}