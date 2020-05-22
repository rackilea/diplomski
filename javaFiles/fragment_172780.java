package foo.bar;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptationAwarePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{

@Override
protected String convertPropertyValue(String originalValue) {
    if (originalValue.startsWith("{AES}")) {
        return decrypt(originalValue.substring(5));
    }
    return originalValue;
}

private String decrypt(String value) {
    return value.toLowerCase(); // here your decryption logic
}