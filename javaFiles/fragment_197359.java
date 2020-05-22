String detailStr=dom2string(fa.getDetail())
System.err.println("FaultCode: " + fa.getFaultCode() + " - Detail: " + detailStr); 


public static final String dom2string(Node node) {
    try {
        if (node == null) {
            return null;
        }

        Transformer tf = transformerThreadLocal.get();
        // Create writer
        StringWriter sw = new StringWriter(buffer, Integer.MAX_VALUE);
        StreamResult result = new StreamResult(sw);

        // transform
        tf.transform(new DOMSource(node), result);

        return sw.getBuffer();
    } catch (Exception e) {
        throw new RuntimeException("Could not convert Node to string", e);
    }
}