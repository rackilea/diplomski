public class TestService {

    public TypedQuery typedQuery;

    public List test(){
        final TypedQuery typedQuery1 = typedQuery.setParameter("a", "a");
        return typedQuery1.setParameter("b", "b").getResultList();
    }
}