class Foo {
    @XmlTransient FooBar c;
    Bar b;
}
class Bar { int x; }
class Zot extends Bar { int y; }
class FooBar { }