public class Trampoline<T>
{
    public T getValue() {
        throw new RuntimeException("Not implemented");
    }

    public Optional<Trampoline<T>> nextTrampoline() {
        return Optional.empty();
    }

    public final T compute() {
        Trampoline<T> trampoline = this;

        while (trampoline.nextTrampoline().isPresent()) {
            trampoline = trampoline.nextTrampoline().get();
        }

        return trampoline.getValue();
    }
}