@Component
public class StringToOfferTypeConverter implements Converter<String, OfferType> {

    @Override
    public OfferType convert(String source) {
        return OfferType.class.getEnumConstants()[Integer.valueOf(source)];
    }
}