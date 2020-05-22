public class CatFactory<T extends Color> implements Factory<T, Cat<T>> {

    private T color;

    public CatFactory(T color) {
        this.color = color;
    }

    @Override
    public Cat<T> create() {
        return new Cat<T>(color);
    }

    public T getColor() {
        return color;
    }

}