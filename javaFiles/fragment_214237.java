public interface MyInterface extends Comparable<MyInterface> {

    @Override
    default int compareTo(MyInterface other) {
        return 0;
    }

}