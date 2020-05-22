public interface IVector<T extends IVector> {
    public T add(T vector);

    public T sub(T vector);

    public double dotProduct(T vector);

    public T scalar(double scalar);
}

public abstract class Vector<T extends Vector> implements IVector<T> {
    final ArrayList<Double> coordinates;

    public Vector(ArrayList<Double> list) {
        coordinates = list;
    }

}

public class AVector extends Vector<AVector> {
    public AVector(ArrayList<Double> list) {
        super(list);
    }

    @Override
    public AVector add(AVector v) {
        ArrayList<Double> newCoordinates = new ArrayList<>();
        if (v.coordinates.size() == this.coordinates.size()) {
            for (int i = 0; i < this.coordinates.size(); i++) {
                newCoordinates.add(v.coordinates.get(i) + this.coordinates.get(i));
            }
        } else return null;
        return new AVector(newCoordinates);
    }

    @Override
    public AVector sub(AVector vector) {
        return null;
    }

    @Override
    public double dotProduct(AVector vector) {
        return 0;
    }

    @Override
    public AVector scalar(double scalar) {
        return null;
    }

}