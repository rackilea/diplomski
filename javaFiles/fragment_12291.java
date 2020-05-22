/* pp */ abstract class BaseType<E extends Enum<E>> {
    private final E[] tags;
    protected BaseType(E[] tags) {
        this.tags = requireNonNull(tags);
    }

    public E getTag(String name) {
        requireNonNull(name);
        for (E tag : tags) {
            if (name.equals(tag.name())) {
                return tag;
            }
        }
        Log.e(this, name+" is not supported tag"); // (sic)
        return null; // (sic)
    }
    ...
}
public class DerivedType extends BaseType<XmlElementType> {
    public DerivedType() {
        super(XmlElementType.values());
    }
    ...
        this.getTag(name)
    ...
}