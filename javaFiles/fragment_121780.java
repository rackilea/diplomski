@RunWith(Parameterized.class)
public class ParameterizedTest {

    private File file;

    public ParameterizedTest(File file) {
        this.file = file;
    }

    @Test
    public void test1() throws Exception {  }

    @Test
    public void test2() throws Exception {  }

    @Parameters
    public static Collection<Object[]> data() {
        // load the files as you want
        Object[] fileArg1 = new Object[] { new File("path1") };
        Object[] fileArg2 = new Object[] { new File("path2") };

        Collection<Object[]> data = new ArrayList<Object[]>();
        data.add(fileArg1);
        data.add(fileArg2);
        return data;
    }
}