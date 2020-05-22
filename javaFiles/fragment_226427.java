public class HashSetTest extends SetTest {

    @Override
    protected Set<String> createSetUnderTest() {
        return new HashSet<String>();
    }
}