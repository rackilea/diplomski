public abstract class AbstractTest {

    // all subclasses have access to these classes
    public class PublicInner {}
    protected class ProtectedInner {}

    // subclasses in the same package have access to this class
    class PackagePrivateInner {}

    // subclasses do not have access to this class
    private class PrivateClass {}

}