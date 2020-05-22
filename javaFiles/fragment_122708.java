public interface BaseMapper<S, T> {

    T toDto(S source);

    S toEntity(T target);
}