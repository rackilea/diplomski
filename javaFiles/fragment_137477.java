public static <T> T coalesce(T a, T b) {
    return a == null ? b : a;
}
public static <T> T coalesce(T a, T b, T c) {
    return a != null ? a : (b != null ? b : c);
}
public static <T> T coalesce(T a, T b, T c, T d) {
    return ...
}