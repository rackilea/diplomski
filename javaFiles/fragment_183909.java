public interface Function<T> {
    T operate(Map<String,T> values);
}

public class Calculation<T> {

     private Map<String,T> values;

     private Function<T> function;

     public Calculation(Map<String,T> values, Function<T> function) {
         this.values = new HashMap<String,T>(values);
         this.function = function;
     }

     public T calculate() {
         return function.operate(Collections.unmodifiableMap(values));
     }

     // assume setters and getters are in place to manipulate the backing map and the functor object

}