public abstract class Animal<T extends Animal<T>> {
    protected List<String> names = new ArrayList<String>();

    public T withName(String name) {
        names.add(name);
        return (T)this;
    }
}