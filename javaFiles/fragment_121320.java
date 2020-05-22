public interface Transformer<I extends BusinessObject, O extends State> {
    public O transformToState(I input);
}

public class GoldTransformer implements Transformer<GoldBO, Gold> {    
    @Override
    public Gold transformToState(GoldBO input) {
        // Code...
    }
}