public final class Utils {
    public static Rect getBorder(final Rect rect, int size, int dx, int dy){
        Rect inflatedRect = inflatedRect(rect, size);
        inflatedRect.offset(dx, dy);

        return inflatedRect;
    }

    public static Rect inflatedRect(final Rect r, int d){
        return new Rect(r.left - d, r.top - d, r.right + d, r.bottom + d);
    }
}