@RunWith(Parameterized.class) 
    public class LengthWithCacheTest  {
        @Parameters(name="{0}")
        public static Collection<Object[]> buildTests() {
            Collection<Object[]> paramRefs = new ArrayList<Object[]>();
            paramRefs.add(new Object[]{null, 0});
            paramRefs.add(new Object[]{"", 1});
            for (int counter = 1 ; counter < 50; counter++) {
                String data = "";
                for (int index = 0 ; index < counter ; index++){
                    data += "a";
                }
                paramRefs.add(new Object[]{data, counter+1});
            }

            return paramRefs;
        }

        private String stringToTest;
        private int expectedLength;

        public LengthWithCacheTest(String string, int length) {
            this.stringToTest = string;
            this.expectedLength = length;
        }



    @Test
    public void verifyLengthEval() {
        LengthWithCache lengthWithCache = new LengthWithCache();
        assertEquals(expectedLength, lengthWithCache.getLenghtPlusOne(stringToTest));
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

           assertEquals(0, plusOneInvkCounter.get());
           lengthWithCache.getLenghtPlusOne(stringToTest);
           assertEquals(1, plusOneInvkCounter.get());
           lengthWithCache.getLenghtPlusOne(stringToTest);
           assertEquals(1, plusOneInvkCounter.get());
           lengthWithCache.getLenghtPlusOne(stringToTest);
           assertEquals(1, plusOneInvkCounter.get());

    }
}