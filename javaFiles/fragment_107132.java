class A
class B extends A implements Foo
class C extends A implements Foo

Foo x = null;
if (whatever) {
x = new B();
} else {
x = new C();
}
x.fooMethod();