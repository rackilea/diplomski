interface WithKey {
    Object key();
}
abstract class AbstractWithKey implements WithKey {
    Object key;
    Object v;
    @Override public Object key() { return key; }
    @Override public String toString() { 
        return MoreObjects.toStringHelper(this).add("k", key).add("v", v).toString(); 
    }
}
class A extends AbstractWithKey {
    public A(int i, String v) { 
        key = i;
        this.v = v;
    } 
}
class B extends AbstractWithKey {
    public B(int i, int v) { 
        key = i;
        this.v = v;
    }
}