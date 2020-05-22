@FunctionalInterface
public interface AcceptingInterface<V, T> {

    T accept(Stream<? extends V> s); 
    default T accept(Optional<? extends V> opt){
        return accept(opt.map(Stream::of).orElseGet(Stream::empty)); 
    }

}