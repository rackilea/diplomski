public class TestEncrypted {
    @EncryptedValue("dGVzdCBzdHJpbmc=");
    public String someEncryptedValue =
        TestEncryptedDecryptedValues.someEncryptedValue;
}

// then generate this class with the annotation processor
final class TestEncryptedDecryptedValues {
    static final String someEncryptedValue = "test string";
}