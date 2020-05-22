private int a;
private int b = 1;
{
    // Initization occurs after b but before c.
    // c cannot be referenced here at all
    int i = SomeClass.getSomeStatic();
    a = i * 2;
}
private int c = 99;