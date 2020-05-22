@XmlRootElement // or @XmlTransient if you want to
public class Plural<S> {

    public static <P extends Plural<S>, S> P newInstance(
            final Class<P> pluralType, final Collection<S> elms) {
        P lt = (P) pluralType.newInstance();
        lt.singulars = new ArrayList<>(elms);
        return lt;
    }

    protected Collection<S> getSingulars() {
        if (singulars == null) {
            singulars = new ArrayList<S>();
        }
        return singulars;
    }

    private Collection<S> singulars;
}