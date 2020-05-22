import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        BooleanWrapper b = new BooleanWrapper();
        CompletableFuture.runAsync(() -> b.setValue(true));
        // ...
    }

    private static class BooleanWrapper {
        private boolean value;

        public boolean getValue() {
            return value;
        }

        public void setValue(boolean value) {
            this.value = value;
        }
    }

}