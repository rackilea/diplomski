@XmlRootElement(name = "xml-gen")
public class XMLObj
{
  private int number1;
  private int number2;
  private int number3;
  private CalculatedValue calculatedValue;


  public int getRandomNumberOne()
  {
    return number1;
  }

  @XmlElement
  public void setRandomNumberOne(int randomNumber1)
  {
    this.number1 = randomNumber1;
  }

  public int getRandomNumberTwo()
  {
    return number2;
  }

  @XmlElement
  public void setRandomNumberTwo(int randomNumber2)
  {
    this.number2 = randomNumber2;
  }

  public int getRandomNumberThree()
  {
    return number3;
  }

  @XmlElement
  public void setRandomNumberThree(int randomNumber3)
  {
    this.number3 = randomNumber3;
  }

  public CalculatedValue getCalculatedValue()
  {
    return calculatedValue;
  }

  public void setCalculatedValue(CalculatedValue calculatedValue)
  {
    this.calculatedValue = calculatedValue;
  }    
}