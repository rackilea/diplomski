/**
 * @deprecated use {@link HSSFColorPredefined} instead
 */
@Deprecated
@Removal(version="3.18")
public static class BRIGHT_GREEN extends HSSFColorRef {
    private static final HSSFColorPredefined ref = HSSFColorPredefined.BRIGHT_GREEN;
    public static final short index = ref.getIndex();
    public static final int index2 = ref.getIndex2();
    public static final short[] triplet = ref.getTriplet();
    public static final String hexString = ref.getHexString();
    public BRIGHT_GREEN() { super(ref); }
}