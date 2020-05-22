@RequiredArgsConstructor
public enum SupportedType {
    STRING(String.class, s -> s),
    INT(int.class, Integer::valueOf);

    @Getter
    private final Class<?> type;

    @Getter
    private final Function<String, Object> converter;
}