public class TransformerC implements Transformer {

    @Override
    public Transformation2<Integer, Character> transform() {
        return (a, b) -> System.out.println(a + b);
    }
}