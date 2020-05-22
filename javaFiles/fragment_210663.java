public static Something createSomething(int x, int y, .....)
{
    /// 1. Implementation
    /// OR
    /// 2. return createSomething(new SomethingDescription(parameters ...));
}

public static Something createSomething(SomethingDescription description)
{
    /// 1. return createSomething(description.x, description.y, ...);
    /// OR
    /// 2. Implementation
}