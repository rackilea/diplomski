import org.mockito.Mockito;

class Scratch {  
    public final static String STATIC_CONST = "static const";
    private final String JUST_CONST = "private const";
    protected String protectedField = "protected field";
    String packageProtectedField = null;

    public static void main(String[] args) {
        Scratch mocked = Mockito.mock(Scratch.class);
        System.out.println("static    = " + mocked.STATIC_CONST);
        System.out.println("const     = " + mocked.JUST_CONST);
        System.out.println("protected = " + mocked.protectedField);
        System.out.println("package   = " + mocked.packageProtectedField);

        mocked.packageProtectedField = "but now";
        System.out.println("updated  = " + mocked.packageProtectedField);
    }
}