public abstract class TypeOfMapObject extends IrrelevantClass implements Serializable, MapObject, Comparable<TypeOfMapObject> {
    @Override
    public int compareTo(TypeOfMapObject m)
    {
        return compareValue().compareTo(m.compareValue());
    }

    // subclasses to return their value to compare
    protected abstract String compareValue();
}