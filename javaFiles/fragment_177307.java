public class Composer<T>{
    private final T element;

    private Composer(T element){
        this.element = element;
    }

    public <T2> Composer<T2> andThen(Function<? super T, ? extends T2> f){
        return new Composer<>(f.apply(element));
    }

    public T get(){
        return element;
    }

    public static <T> Composer<T> of(T element){
        return new Composer<T>(element);
    }
}