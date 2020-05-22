@Override
public T[] postOrder() {
    ArrayList<T> array = new ArrayList<T>();
    postOrder(root, array);
    return (T[]) array.toArray(
        java.lang.reflect.Array.newInstance(myClassT, array.size())
    );
}