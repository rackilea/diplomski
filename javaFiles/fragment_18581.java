class Container {
  private final int integer;
  private final HashMap<String, Stuff> stuff1;
  private final HashMap<String, Stuff> stuff2;
}

class Stuff {
  private final String name;
  private final String description;
  @SerializedName("boolean") private final boolean bool;
  private final HashMap<String, Option> more;
}

class Option {
  private final String name;
}