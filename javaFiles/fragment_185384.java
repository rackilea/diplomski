public abstract class PlanetaryBody {

    /**
     * @return If this PlanetaryBody is a Star, then an Optional containing this as a Star.
     * Otherwise an empty Optional.
     */
    public Optional<Star> asStar() {
        return Optional.empty();
    }

    public Optional<Planet> asPlanet() {
        return Optional.empty();
    }

    // Similar methods for other subclasses

}