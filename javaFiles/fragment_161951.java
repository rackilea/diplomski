public class Test {

    public static void main(String[] args) {
        tryWithVoid();
        //      tryWithCompletionStageVoid();
    }

    public static void tryWithVoid() {
        System.out.println("Started");
        validate(null);
        System.out.println("Exit");
    }

    public static void tryWithCompletionStageVoid() {
        System.out.println("Started");
        validateCS(null).thenRun(() -> System.out.println("Validation complete"));
        System.out.println("Exit");
    }

    public static CompletionStage<Void> validateCS(String val) {
        return CompletableFuture.runAsync(() -> {
            if (val == null) {
                System.out.println("Validation failed! value is null");
            }
        });
    }

    public static void validate(String val) {
        CompletableFuture.runAsync(() -> {
            if (val == null) {
                System.out.println("Validation failed! value is null");
            }
        });
    }
}