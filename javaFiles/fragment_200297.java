public class ValidationTest {

    private int index;
    private DataLoader loader;

    public ValidationTest(int index, DataLoader loader) {
        this.number = number;
        this.loader = loader;
    }

    @Test(dependsOnGroups = "Main")
    public void validate() {
        Location location = this.loader.getLocation(this.index);
        // do whatever with location.x and location.y
    }
}