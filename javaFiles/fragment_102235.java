public class AbstractFactory{
    private final Vector vector;

    protected AbstractFactory(Vector vector){
        this.vector = vector;
    }

    protected Vector void getVector() {
        return vector;
    }

    public abstract Circle createCircle();
}