public class IVP {
    private Integrator integrator;

    public IVP(Integrator integrator) {
        this.integrator = integrator;
    }

    public Point function(Double x, Point y) {
        // Calculate using integrator.integrate();
    }
}