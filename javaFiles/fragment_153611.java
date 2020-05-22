public class OrDoerElement {
    private final Number numberValue;
    private final CharSequence charSequenceValue;

    private OrDoerElement(Number number, CharSequence charSequence) {
        this.numberValue = number;
        this.charSequenceValue = charSequence;
    }

    public static OrDoerElement fromCharSequence(CharSequence value) {
        return new OrDoerElement(null, value);
    }

    public static OrDoerElement fromNumber(Number value) {
        return new OrDoerElement(value, null);
    }
}