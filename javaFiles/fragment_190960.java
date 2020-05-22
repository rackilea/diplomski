public abstract class BuildingMaterial {

    private int amount;

    //constructors
    public BuildingMaterial() {
      this(0);
    }

    public BuildingMaterial(int i) {
      amount = i;
    }

    //methods
    public int getAmount() {
      return amount;
    }

}