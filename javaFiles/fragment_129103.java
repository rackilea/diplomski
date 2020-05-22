public class Distance implements Collector<Vector3D, Distance.Helper, Double> {

    public static final Distance COLLECTOR = new Distance();

    static final class Helper {
        private double sum = 0;
        private Vector3D first = null, previous = null;
    }
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
    public Supplier<Helper> supplier() {
        return Helper::new;
    }
    public BiConsumer<Helper, Vector3D> accumulator() {
        return (helper,vector3d)-> {
            if (helper.previous != null)
                helper.sum += vector3d.distance(helper.previous);
            else helper.first = vector3d;
            helper.previous = vector3d;
        };
    }
    public BinaryOperator<Helper> combiner() {
        return (h1,h2)-> {
            h2.sum += h1.sum;
            if(h1.previous!=null && h2.first!=null) {
                h2.sum += h1.previous.distance(h2.first);
                h2.first=h1.first;
            }
            return h2;
        };
    }
    public Function<Helper, Double> finisher() {
        return helper -> helper.sum;
    }
}