@XmlRootElement
public class CalculatedValue
{
  private int calculatedValue;
  private String calculation;

  @XmlAttribute
  public int getCalculatedValue()
  {
    return calculatedValue;
  }

  public void setCalculatedValue(int calculatedValue)
  {
    this.calculatedValue = calculatedValue;
  }

  @XmlValue
  public String getValue()
  {
    return calculation;
  }

  public void setValue(String calculation)
  {
    this.calculation = calculation;
  }
}