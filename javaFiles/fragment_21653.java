//Test code of course.
public class Start{
  public static void main(String args[]){
    System.out.println(Machine.COFFEE_GRINDER.getCatalogId());
    System.out.println(Machine.COFFEE_MACHINE.isOfType(Machine.BASIC_MACHINE)); //Should be true.
  }

  private enum Machine {
    BASIC_MACHINE (-1),
    BEVERAGE (-1, BASIC_MACHINE),
    COFFEE(-1, BEVERAGE),
    COFFEE_GRINDER (5, COFFEE),
    COFFEE_MACHINE (6, COFFEE),
    GARDEN (-1, BASIC_MACHINE),
    LAWN_MOWER (28, GARDEN);

    private int catalogId;
    private Machine superMachine;

    public int getCatalogId(){
      return catalogId;
    }

    public Machine getSuperMachine(){
      return superMachine;
    }

    //With callback to superMachine (if present)
    public boolean isOfType(Machine to){
      return this == to || (getSuperMachine() != null && getSuperMachine().isOfType(to));
    }

    Machine (int catalogId) {
      this.catalogId = catalogId;
    }

    Machine (int catalogId, Machine superMachine) {
      this(catalogId);
      this.superMachine = superMachine;
    }
  }
}