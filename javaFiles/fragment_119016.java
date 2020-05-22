public interface Shape<T extends Shape<T>> {
    T getType();
    void setType(T type);
}

public class Circle implements Shape<Circle> {
    Circle getType() { }
    void setType(Circle circle) {  }
}