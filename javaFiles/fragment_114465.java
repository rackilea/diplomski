public class Foo {
    private String encrypted = "<manually created encrypted string>";
    private String key = "<key used for encryption";
    private String mySecret = MyDecryptUtil.decrypt(encrypted, key);

    ...
}