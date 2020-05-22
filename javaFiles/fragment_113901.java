public class Box<T> {

    public static void main(String[] args) {
        Box a = new Box();
        Box b = new Box<>();
        Box c = new Box<Integer>();
        Box d = new Box<String>();
    }
}