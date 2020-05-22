public class A 
{
    public delegate int Int32Func();

    private static Int32Func[] functions;

    // Note: this is *not* thread safe...
    public static void Foo() {
        if (functions == null) {
            functions = new Int32Func[]
            {
                () => 1,
                () => 2,
                () => 3
            };
        }
    }
}