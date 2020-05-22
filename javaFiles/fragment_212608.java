public class TransformerD implements Transformer {

    public Transformation3<Integer, Double, String> transform() {
        return (a, b, c) -> System.out.println(a + b + c);
    }
}