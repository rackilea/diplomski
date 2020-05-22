public class LengthWithCacheTest {
    @Test
    public void verifyLengthEval() {
        LengthWithCache lengthWithCache = new LengthWithCache();
        assertEquals(6, lengthWithCache.getLenghtPlusOne("apple"));
    }

    @Test
    public void verifyInvocationCounts() {
        final AtomicInteger plusOneInvkCounter = new AtomicInteger();
        LengthWithCache lengthWithCache = new LengthWithCache() {
            @Override
            protected int determineLengthPlusOne(String string) {
                plusOneInvkCounter.incrementAndGet();
                return super.determineLengthPlusOne(string);
            }
        };

           lengthWithCache.getLenghtPlusOne("apple");
           assertEquals(1, plusOneInvkCounter.get());

           lengthWithCache.getLenghtPlusOne("apple");
           lengthWithCache.getLenghtPlusOne("apple");
           lengthWithCache.getLenghtPlusOne("apple");
           lengthWithCache.getLenghtPlusOne("apple");
           lengthWithCache.getLenghtPlusOne("apple");
           lengthWithCache.getLenghtPlusOne("apple");

           assertEquals(1, plusOneInvkCounter.get());
    }
}