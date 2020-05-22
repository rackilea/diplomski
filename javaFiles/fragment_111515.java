public class Ferry implements Voyage {
  ...

  private String type_voyage;

  ...

  @Override
  public String getType_voyage() {
      return type_voyage;
  }

  ...

}