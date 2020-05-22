public interface IVector<T extends IVector> {
    public T add(T vector);

}

public interface Factory<T> {
    public T makeNew (ArrayList<Double> coordinates);
}

public abstract class Vector<T extends Vector<T> & Factory<T>> implements IVector<T> {
    final ArrayList<Double> coordinates;

    public Vector(ArrayList<Double> list) {
        coordinates = list;
    }

    @Override
    public T add(T v) {
        if (v.coordinates.size() == this.coordinates.size()) {
            ArrayList<Double> newCoordinates = new ArrayList<>();
            for (int i = 0; i < this.coordinates.size(); i++) {
                newCoordinates.add(v.coordinates.get(i) + this.coordinates.get(i));
            }
            // Use the passed parameter as a factory.
            return v.makeNew(coordinates);
        }
        return null;
    }

}

public class AVector extends Vector<AVector> implements Factory<AVector> {
    public AVector(ArrayList<Double> list) {
        super(list);
    }

    @Override
    public AVector makeNew(ArrayList<Double> coordinates) {
        return new AVector(coordinates);
    }
}