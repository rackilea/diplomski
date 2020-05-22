%ignore Bar;
%inline %{
class Bar {
public:
  double baz() { return 4.2; }
};
class Foo : private Bar {
public:
  using Bar::baz;
};
%}