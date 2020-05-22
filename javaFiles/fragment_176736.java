public class SomeBean {
    private String a;
}

public class SomeOtherBean {
    private SomeBean someBean;
    ...
}

public class Foo {
    private final SomeOtherBean someOtherBean;
    private /* non-final */ SomeOtherBean someOtherBean2;
}