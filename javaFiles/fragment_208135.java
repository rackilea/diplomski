abstract class AbstractListTest<T> {
    protected abstract List<T> createList();

    @Test
    public void testIsEmpty() {
        List<T> list = createList();
        assertTrue(list.isEmpty());
    }

    ...more tests...
}

class QuickListTest extends AbstractListTest<QuickList> {
    protected QuickList createList() {
        return new QuickList();
    }
}