@Getter @Setter
public class VehicleDTO {

    private String name;
    private boolean hasWheels;
    private boolean hasWings;
    private boolean hasBrakes;

    public boolean hasHasWheels() {
        return hasWheels;
    }
}