package org.example.pkg.foo;
public class Foo {
    public static void doSomething();
}

package org.example.pkg.bar;
public class Bar {
    public void bar() {
        org.example.pkg.foo.Foo.doSomething();
    }
}