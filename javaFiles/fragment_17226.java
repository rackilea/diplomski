public class EnumTest extends TestCase {
    private enum X {
        A, B, C;
        public X successor() {
                return values()[(ordinal() + 1) % values().length];
        }
    };

    public void testSuccessor() throws Exception {
        assertEquals(X.B, X.A.successor());
        assertEquals(X.C, X.B.successor());
        assertEquals(X.A, X.C.successor());
    }
}