public abstract class ReferenceRange<T> {

    public abstract T getReference();
}

public class IntegerReferenceRange extends ReferenceRange<Integer> {

    private Integer reference;

    @Override
    public Integer getReference() {
        return reference;
    }
}