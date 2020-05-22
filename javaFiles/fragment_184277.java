import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class ListConverter<From, To> implements Converter<From, To> {

    private final Supplier<List<To>> listFactory;

    public ListConverter(Supplier<List<To>> listFactory) {
        this.listFactory = listFactory;
    }

    public List<To> convertList(List<From> fromList) {
        if (fromList == null) {
            return null;
        }

        List<To> toList = listFactory.get();
        for (From from : fromList) {
            toList.add(this.convert(from));
        }

        return toList;
    }

    public static <From, To> ListConverter<From, To> extend(Converter<From, To> converter, Supplier<List<To>> listFactory) {
        return new ListConverter<From, To>(listFactory) {

            @Override
            public To convert(From from) {
                return converter.convert(from);
            }
        };
    }

    public static <From, To> ListConverter<From, To> extend(Converter<From, To> converter) {
        return extend(converter, ArrayList::new);
    }
}