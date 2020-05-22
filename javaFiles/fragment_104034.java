public class SomeEntityTest {

    @Test
    public void test() {
        SomeEntity entity = new SomeEntity();

        Collection<String> test1 = Arrays.asList(new String[] { "1", "2" });
        entity.setFieldOne(test1);
        assertSame(test1, entity.getFieldOne());

        Collection<String> test2 = new HashSet<String>(Arrays.asList(new String[] { "3", "4" }));
        entity.setFieldTwo(test2);
        assertSame(test2, entity.getFieldTwo());

        assertTrue(entity.fieldOneContains("1"));
        assertTrue(entity.fieldOneContains("2"));
        assertFalse(entity.fieldOneContains("3"));
        assertFalse(entity.fieldOneContains("4"));

        assertFalse(entity.fieldTwoContains("1"));
        assertFalse(entity.fieldTwoContains("2"));
        assertTrue(entity.fieldTwoContains("3"));
        assertTrue(entity.fieldTwoContains("4"));

        try {
            entity.setFieldOne(null);
            fail("exception expected");
        } catch (Exception ex) {
        }

        try {
            entity.setFieldTwo(null);
            fail("exception expected");
        } catch (Exception ex) {
        }

    }
}