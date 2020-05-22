public interface Converter<I, O> {

    void tranformer(List list);

    O retriever(I obj);
}