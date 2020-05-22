import static ProtocolOperation.*;

public enum HttpMethodName {
    GET(RETRIEVE),
    POST(CREATE, NOTIFY),
    PUT(UPDATE),
    DELETE(ProtocolOperation.DELETE);

    final List<ProtocolOperation> ops;

    HttpMethodName(ProtocolOperation... ops) {
        this.ops = Collections.unmodifiableList(Arrays.asList(ops));
    }
}