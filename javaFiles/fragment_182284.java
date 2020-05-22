class StringFoo implements Foo<String>
{
    public String foo() { ... }

    public /* synthetic bridge */ Object foo() // desc: ()Ljava/lang/Object;
    {
        return /* String */ foo(); // statically linked to String foo()
    }

    public void bar(String value) { ... }

    public /* synthetic bridge */ void bar(Object value) // desc: (Ljava/lang/Object;)
    {
        return bar((String) value);
    }

    public String baz() { ... }

    public /* synthetic bridge */ Object baz() // desc: ()Ljava/lang/Object;
    {
        return /* String */ baz(); // statically linked to String baz()
    }
}