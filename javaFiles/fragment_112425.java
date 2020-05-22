public enum AnimalsEnum
{
  CAT("An animal with four legs",
      EnumSet.of(ColorsEnum.BROWN, ColorsEnum.GREY)),
  BIRD("An animal with two legs and two wings",
       EnumSet.of(ColorsEnum.GREY, ColorsEnum.YELLOW, ColorsEnum.ORANGE));

  private AnimalsEnum(String              description,
                      EnumSet<ColorsEnum> possible_colors)
  {
    this.description = description;
    this.possible_colors = possible_colors;
  }

  public String getDescription()
  {
    return description;
  }

  public EnumSet<ColorsEnum> getPossibleColors()
  {
    return (possible_colors);
  }

  public static AnimalsEnum getAnimal(String description)
  {
    return (descr_map.get(description));
  }

  private String description;

  private EnumSet<ColorsEnum> possible_colors;

  private static HashMap<String, AnimalsEnum> descr_map;

  static
  {
    descr_map = new HashMap<String, AnimalsEnum>();
    for (AnimalsEnum animal : values())
    {
      descr_map.put(animal.getDescription(), animal);
    }    
  }

} // enum AnimalsEnum