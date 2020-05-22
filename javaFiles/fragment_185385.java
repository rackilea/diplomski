public class Star extends PlanetaryBody {

    public void shineBrightly() {
        // ...
    }

    @Override
    public Optional<Star> asStar() {
        return Optional.of(this);
    }

}