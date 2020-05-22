@XmlTransient
public class Plural<S> {

    public static <P extends Plural<S>, S> P newInstance(
        final Class<P> pluralType) {
        return newInstance(pluralType, Collections.<S>emptyList());
    }

    public static <P extends Plural<S>, S> P newInstance(
        final Class<P> pluralType, final Collection<? extends S> singulars) {
        try {
            final P plural = pluralType.newInstance();
            plural.getSingulars().addAll(singulars);
            return plural;
        } catch (InstantiationException ie) {
            throw new RuntimeException(ie);
        } catch (IllegalAccessException iae) {
            throw new RuntimeException(iae);
        }
    }

    protected Collection<S> getSingulars() {
        if (singulars == null) {
            singulars = new ArrayList<S>();
        }
        return singulars;
    }

    private Collection<S> singulars;
}

@XmlAccessorType(XmlAccessType.NONE)
public class Item {

    public static Item newInstance(final long id, final String name) {
        final Item instance = new Item();
        instance.id = id;
        instance.name = name;
        return instance;
    }

    @Override
    public String toString() {
        return id + "/" + name;
    }

    @XmlAttribute
    private long id;

    @XmlValue
    private String name;
}

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Items extends Plural<Item> {


    @XmlElement(name = "item")
    public Collection<Item> getItems() {
        return getSingulars();
    }
}