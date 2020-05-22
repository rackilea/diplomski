abstract class GCollectionTest<T> {
    protected Collection<T> collection;

    protected abstract Collection<T> createCollection();
    protected abstract T createObject();

    @Before
    public void setup() throws Exception {
        collection = createCollection();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(collection.isEmpty());
        collection.add(createObject());
        assertFalse(collection.isEmpty());
    }
}

class GStackCollectionInterfaceTest extends GCollectionTest<String> {
    protected GDSStack<String> createCollection() {
        return new GDSStack<String>();
    }

    protected String createObject() {
        return new String("123");
    }
}