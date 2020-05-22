public enum PlaneEnum
{
  FOCKE_WULF_190("Focke-Wulf Fw 190", 190),
  MESSERSCHMITT_109("Messerschmitt Bf 109", 109),
  ....

  public String toString()
  {
    return (myDescr);
  }

  public double getValue()
  {
    return (myValue);
  }

  private PlaneEnum(String description,
                    double value)
  {
    myDescr = description;
    myValue = value;
  }

  private String myDescr;
  private double value;

} // enum PlaneEnum

JComboBox<PlaneEnum> = new JComboBox<PlaneEnum>(PlaneEnum.values);