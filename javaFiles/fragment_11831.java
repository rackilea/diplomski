@Parameters(name = "{index}")
public static Iterable<Object[]> getLoadTest() {

    return Arrays.asList(new Object[][] {
        {
            new int[][]{{6, 1}, {4, 1}}, 4.5
        },
        {
            new int[][]{{4, 1}, {4, -1}, {0, 0}, {6, 1}}, 5.0
        }

    });
}