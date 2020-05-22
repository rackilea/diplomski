public class TransformerB implements Transformer {

    @Override
    public Transformation1<String> transform() {
        return a -> System.out.println(a); // or System.out::println
    }
}