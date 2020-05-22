public class Builder<T extends Base> {
    private final List<Def1> subDefs1 = new ArrayList<>();
    private final List<Def2> subDefs2 = new ArrayList<>();

    public Builder<T> add(final Collection<Def1> ds) {
        subDefs1.addAll(ds);
        return this;
    }

    public Builder<T> add(final Collection<Def2> ds) {
        subDefs2.addAll(ds);
        return this;
    }
}

interface Base {}

final class Def1 implements Base {}

final class Def2 implements Base {}