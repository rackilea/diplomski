interface StringProvider {  // an interface that will produce a String
    String getStringValue();
}

class PlainStringProvider implements StringProvider {
    private String stringValue;
    public PlainStringProvider(String stringValue) {
        this.stringValue = stringValue;
    }
    @Override
    public String getStringValue() {
        return this.stringValue;
    }
}

class StringProviderDecorator implements StringProvider {
    private StringProvider delegate;
    public StringProviderDecorator(StringProvider delegate) {
        this.delegate = delegate;
    }
    @Override
    public String getStringValue() {
        return this.delegate.getStringValue();
    }
}

class EncryptStringProvider extends StringProviderDecorator {
    public EncryptStringProvider(StringProviderDecorator delegate) {
        super(delegate);
    }
    // your stuff about encryption
}


class DecryptStringProvider extends StringProviderDecorator {
    public DecryptStringProvider (StringProviderDecorator delegate) {
        super(delegate);
    }
    // your stuff about decryption
}