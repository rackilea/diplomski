public class Scratch4 {
    public static void main(String args[]) {
        EventBus.getDefault()
                .register(new D());

        EventBus.getDefault()
                .post(new E());

    }
}