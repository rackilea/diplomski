public class AnimalColors extends HashMap<String, EnumSet<ColorsEnum>>
{
  private AnimalColors()
  {
    put("An animal with four legs", EnumSet.of(ColorsEnum.BROWN, ColorsEnum.GREY));
    put("An animal with two legs and two wings", EnumSet.of(ColorsEnum.GREY, ColorsEnum.YELLOW, ColorsEnum.ORANGE));
  }

  public static AnimalColors get()
  {
    return my_instance;
  }

  private static AnimalColors my_instance = new AnimalColors();

} // class AnimalColors