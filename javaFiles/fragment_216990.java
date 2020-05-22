public class Ferrari extends PoweredVehicle
{   
    public Ferrari(Engine engine) {
        super(engine);
    }

    Ferrari f = new Ferrari(engine); // Why would you do this here?

    @Override
    public void Drive() {
        super.Drive();
        System.out.println("Ferrari driving...");
    } 
}