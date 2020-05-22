public class SpotLight {     
    public enum State {
        On,
        Off,
        Dimmed
    }

    private State state;

    public SpotLight(State state) {
        this.state = state;
    }

    ...
}