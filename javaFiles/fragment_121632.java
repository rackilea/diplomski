@Builder // lombok annotation
class A {
    private B b;
}

A a = A.builder().withB(b).build();