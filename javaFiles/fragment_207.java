@RunWith(Parameterized.class)
public class ATest {
    private String value1;
    private String value2;

    private static final String ABC = "abc";
    private static final String XYZ = "xyz";

    public ATest(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Test(expected=NullPointerException.class)
    public void nullPassedToConstructor() {
         A a = new A(value1, value2);
    }

    // Provide data
    @Parameters
    public static List<Object[]> data() {
    List<Object[]> list = new ArrayList<Object[]>();

        list.add(new Object[] {null, XYZ});
        list.add(new Object[] {ABC, null});
        list.add(new Object[] {null, null});

        return list;
    }
}