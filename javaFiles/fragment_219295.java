public class MyBinaryTreeNodeG<T> {

    Comparable<T> data;

    // ...

    public MyBinaryTreeNodeG<T> addChild(final T data) {
        if (this.data.compareTo(data) <= 0) {
        } else {
        }
        // ...
    }
}