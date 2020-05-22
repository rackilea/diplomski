Caused by: java.lang.NoSuchMethodError: org.bouncycastle.openpgp.PGPPublicKeyRingCollection.<init>(Ljava/io/InputStream;)V
    at org.apache.camel.converter.crypto.PGPDataFormatUtil.findPublicKey(PGPDataFormatUtil.java:64)
    at org.apache.camel.converter.crypto.PGPDataFormatUtil.findPublicKey(PGPDataFormatUtil.java:54)
    at org.apache.camel.converter.crypto.PGPDataFormat.marshal(PGPDataFormat.java:64)
    at org.apache.camel.processor.MarshalProcessor.process(MarshalProcessor.java:59)
    at org.apache.camel.util.AsyncProcessorConverterHelper$ProcessorToAsyncProcessorBridge.process(AsyncProcessorConverterHelper.java:61)