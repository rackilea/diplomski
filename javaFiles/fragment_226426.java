public abstract class SetTest {

    @Test
    public void addAlreadyExistentObject(){
        Set<String> setUnderTest = createSetUnderTest();
        Assert.assertTrue(setUnderTest.isEmpty());

        boolean setChanged = setUnderTest.add("Hello");
        Assert.assertTrue(setChanged);

        setChanged = setUnderTest.add("Hello");
        Assert.assertFalse(setChanged);

        Assert.assertEquals(setUnderTest.size(), 1);

    }

    protected abstract Set<String> createSetUnderTest();

}