final class A {
    String value = "default";
}

A instance = new A();
A[] array = new A[] {instance};
instance.value = "another value";
assert instance == array[0];
assert instance.value == array[0].value;