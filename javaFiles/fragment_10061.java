class Foo {
public:
   void bar();
   void foo() const;
};

void test(const Foo& i) {
   i.foo(); //fine
   i.bar(); //error
}