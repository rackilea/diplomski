// class Foo is public
public class Foo
{
    final private Bar bar = ...;
}

// class Bar is package-private
// (visible to all classes in the package, not visible outside the package)
class Bar
{
    ...;
}