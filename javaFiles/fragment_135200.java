// Singleton with public final field
public class Elvis {
    public static final Elvis Elvis = new Elvis();
    private Elvis() { ... }

    public void leaveTheBuilding() { ... }
}