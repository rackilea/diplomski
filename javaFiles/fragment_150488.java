public class ListTest {

    public static Stream<List<String>> lists() {
        return Stream.of(new ArrayList<>(), new LinkedList<>());
    }

    @ParameterizedTest
    @MethodSource("lists")
    public void testAdd(List<String> list) {
        list.add("xyz");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("xyz", list.get(0));
    }
}