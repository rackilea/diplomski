interface Foo<T>
{
    T foo(); // desc: ()Ljava/lang/Object;

    void bar(T value); // desc: (Ljava/lang/Object;)V

    Object baz(); // desc: ()Ljava/lang/Object;
}

class StringFoo implements Foo<String>
{
    @Override
    public String foo() { ... } // desc: ()Ljava/lang/String; // !

    @Override
    public void bar(String value) { ... } // desc: (Ljava/lang/String;)V // !

    @Override
    public String baz() { ... } // desc: ()Ljava/lang/String; // !
}