private ValContainer<CompletableFuture<String>> valContainer = new ValContainer<>(new CompletableFuture<>());


public class ValContainer<T> {
    T val;

    public ValContainer(T val) {
        this.val = val;
    }
}