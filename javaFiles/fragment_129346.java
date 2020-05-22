@Embeddable
public class EncodedString {

    @Column(name = "problematic_field")
    private byte[] array;

    @Column(name = "charset", nullable = false)
    private String charset;

    @Transient
    private String value;

    private EncodedString() {
        // for Hibernate
    }

    public EncodedString(String value, String charset) {
        this.charset = charset;
        this.array = value == null ? null : value.getBytes(charset);
        this.value = value;
    }

    public String getValue() {
        if (value == null && array != null) {
            value = new String(array, charset);
        }
        return value;
    }

    public String getCharset() {
        return charset;
    }
}