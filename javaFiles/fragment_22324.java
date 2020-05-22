public class MultiSetTest {
    @Test
    public void testMultiSet(){
        MultiSet<String> counterSet = new HashMultiSet<>();
        counterSet.add("Hello");
        counterSet.add("world");
        counterSet.add("Hello");

        Assert.assertEquals(2, counterSet.getCount("Hello"));
        Assert.assertEquals(1, counterSet.getCount("world"));
        Assert.assertEquals(0, counterSet.getCount("somethingMissing"));
    }
}