@SuppressWarnings("unchecked")
public <S, D> D convert(final Class<S> source, final Class<D> destination, final S value) {
    final Converter<S, D> converter = (Converter) converters.get(source, destination);

    return destination.cast(converter.convert(source.cast(value)));
}