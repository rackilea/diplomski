import java.util.ArrayList;
import java.util.List;

public abstract class ListConverter<From, To> implements Converter<From, To> {

    private final ListFactory<To> listFactory;

    public ListConverter(ListFactory<To> listFactory) {
        this.listFactory = listFactory;
    }

    public List<To> convertList(List<From> fromList) {
        if (fromList == null) {
            return null;
        }

        List<To> toList = listFactory.newList();
        for (From from : fromList) {
            toList.add(this.convert(from));
        }

        return toList;
    }

    public static <From, To> ListConverter<From, To> extend(Converter<From, To> converter, ListFactory<To> listFactory) {
        return new ListConverter<From, To>(listFactory) {
            @Override
            public To convert(From from) {
                return converter.convert(from);
            }
        };
    }

    public static <From, To> ListConverter<From, To> extend(Converter<From, To> converter) {
        return extend(converter, new ListFactory<To>() {
            @Override
            public List<To> newList() {
                return new ArrayList<To>();
            }
        });
    }
}