public enum ProtocolOperation {
    CREATE(1, HttpMethodName.POST),
    RETRIEVE(2, HttpMethodName.GET),
    UPDATE(3, HttpMethodName.PUT),
    DELETE(4, HttpMethodName.DELETE),
    NOTIFY(5, HttpMethodName.POST);

    private BigInteger operationId;
    private HttpMethodName methodName;

    public BigInteger getOperationId() {
        return operationId;
    }

    public HttpMethodName getMethodName() {
        return methodName;
    }

    private ProtocolOperation(int operationId, HttpMethodName httpMethodName) {
        this.methodName = httpMethodName;
        this.operationId = BigInteger.valueOf(operationId);
    }
}

public enum HttpMethodName {
    GET,
    POST,
    PUT,
    DELETE;

    List<ProtocolOperation> getProtocolOperations() {
        List<ProtocolOperation> ops = new ArrayList<ProtocolOperation>(2);
        for (ProtocolOperation op : ProtocolOperation.values()) {
            if (op.getMethodName() == this) {
                ops.add(op);
            }
        }
        return ops;
    }
}