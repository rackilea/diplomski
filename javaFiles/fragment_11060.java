@XmlJavaTypeAdapter(ErrorCode.Xml.Adapter.class)
enum ErrorCode {
    USERNAME_EXISTS("1001", "The specified username already exists."),
    EMAIL_IN_USE("1002", "The specified email address is already in use.");

    private final String code;
    private final String message;
    private ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {"code", "message"})
    static final class Xml {
        private String code;
        private String message;
        Xml(ErrorCode v) {
            this.code = v.getCode();
            this.message = v.getMessage();
        }

        static final class Adapter extends XmlAdapter<Xml, ErrorCode> {
            @Override
            public Xml marshal(ErrorCode v) throws Exception {
                return new Xml(v);
            }
            @Override
            public ErrorCode unmarshal(Xml v) throws Exception {
                throw new UnsupportedOperationException();
            }
        }
    }
}