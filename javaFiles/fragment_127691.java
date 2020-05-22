class classB { }
interface interfaceC { }

public class MyClass<T extends classB & interfaceC> {
    Class<T> variable;
}