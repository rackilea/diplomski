public class Number {

    private int numberInput;

    public Number(int input)
    {
      this.numberInput = input;
    }

    public String getBinary()
    {
      return Integer.toBinaryString(numberInput);
    }