class MyObjUtil {
    public static <T> @NonNull T requireNonNull(@Nullable T obj) {
        if(obj==null) throw new NullPointerException();
        return obj;
    }
}