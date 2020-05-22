public interface TypeAdapterFactory {
    /**
    * Returns a type adapter for {@code type}, or null if this factory doesn't
    * support {@code type}.
    */
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type);
}