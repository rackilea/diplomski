class DataTypaA<T extends DataTypeC> {
    public T getData() { return null; }
    public T getItems() { return null; }
}
class SparseArray<T, S> {
    public T get(int foo) { return null; }
    public void setTheData(S items){}
}
class DataTypeB {
}
class DataTypeC {
    // do NOT use the raw type List - just done to get your code to compile
    public List getList() { return null; }
}
abstract class FragmentStatePagerAdapter {
    public abstract int getCount();
}
class FragmentManager {
}