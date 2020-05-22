import java.util.HashMap;
import java.util.HashSet;

public class Multiset<E> extends HashSet<E> {
    private static final long           serialVersionUID    = -9013417064272046980L;
    private final HashMap<E, Integer>   multiplicities      = new HashMap<E, Integer>();

    public boolean add(E element) {
        return add(element, 1);
    }

    private boolean add(E element, int copies) {
        if (!contains(element))
            multiplicities.put(element, 0);
        int n = multiplicities.get(element);
        multiplicities.put(element, n + copies);
        return super.add(element);
    }

    /**
     * Adds all of the elements of another multiset to this one. This method allows the preservation of multiplicities which would not occur
     * using the superclass's addAll().
     * 
     * @param that
     * @return true if all elements were successfully added
     */
    public boolean addAll(Multiset<E> that) {
        boolean flag = false;
        for (E element : that)
            flag = add(element, that.multiplicity(element));
        return flag;
    }

    /**
     * The set-view of a multiset is the ordinary set of all elements with multiplicity >= 1.
     * 
     * @return all elements that have multiplicity >= 1
     */
    public Multiset<E> setView() {
        Multiset<E> set = new Multiset<E>();
        for (E o : multiplicities.keySet())
            set.add(o);
        return set;
    }

    /**
     * provides a union of two multisets whereby the multiplicity of each element is the larger of the two
     * 
     * @param that
     * @return
     */
    public Multiset<E> union(Multiset<E> that) {
        HashSet<E> both = new HashSet<E>();
        both.addAll(this);
        both.addAll(that);
        Multiset<E> union = new Multiset<E>();
        for (E element : both)
            union.add(element, Math.max(this.multiplicity(element), that.multiplicity(element)));
        return union;
    }

    /**
     * provides an intersection of two multisets whereby the multiplicity of each element is the smaller of the two
     * 
     * @param that
     * @return The multiset containing the intersection of two multisets
     */
    public Multiset<E> intersect(Multiset<E> that) {
        Multiset<E> intersection = new Multiset<E>();
        final Multiset<E> other = that.setView();
        for (E element : this.setView())
            if (other.contains(element))
                intersection.add(element, Math.min(this.multiplicity(element), that.multiplicity(element)));
        return intersection;
    }

    /**
     * The Multiplicity is the number of occurrences of an object in the multiset
     * 
     * @param element
     * @return number of occurrences of o
     */
    public int multiplicity(E element) {
        return contains(element) ? multiplicities.get(element) : 0;
    }

    public int cardinality() {
        int card = 0;
        for (Integer n : multiplicities.values())
            card += n;
        return card;
    }

    /**
     * Measures the similarity between two multisets
     * 
     * @param that
     * @return the cardinality of the difference of A and B
     */
    public int similarityOfMultisets(Multiset<E> that) {
        return union(that).cardinality() - intersect(that).cardinality();
    }
}