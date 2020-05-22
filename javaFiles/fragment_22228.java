public interface Converter<T> {

    public T convert(T s);
}


public abstract class AbstractConverter<T> implements Converter<T> {

    @Override
    public final T convert(T s) {
         if (s == null) throw new IllegalArgumentException("input can't be null");
         //logger.debug("Input = " + s);
         T r = doConverter(s);
         //logger.debug("Output = " + s);
         return r;
    }

    public abstract T doConverter(T s);
}


public class StringConverter extends AbstractConverter<String> {

    public String doConverter(String s) {
        String r = s + "abc";
        return r;
    };
}

public class IntegerConverter extends AbstractConverter<Integer> {

    public Integer doConverter(Integer s) {
        Integer r = s + 10;
        return r;
    };
}