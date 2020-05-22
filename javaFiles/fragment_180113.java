public class DsrCollectionRepositoryManagerTest {
    @Test
    public void removeObjectSuccessful() {
        boolean expected = true;
        DsrCollectionRepositoryManager dsrCollectionRepositoryManager = new DsrCollectionRepositoryManager() {
            @Override
            protected boolean removeByObjectOrThrow() {
                try {
                    boolean actual = super.removeByObjectOrThrow();
                    Assert.assertEquals(actual, expected);
                    return actual;
                } catch (Exception cause) {
                    String message = "`removeObject` should not have thrown an exception but did";
                    throw new AssertionError(message, cause);
                }
            }
        };
        dsrCollectionRepositoryManager.removeByObject();
    }

    @Test
    public void removeObjectUnsuccessful() {
        DsrCollectionRepositoryManager dsrCollectionRepositoryManager = new DsrCollectionRepositoryManager() {
            @Override
            protected boolean removeByObjectOrThrow() {
                super.removeByObjectOrThrow();
                String detailMessage = "`removeByObject` should have thrown an exception but did not";
                throw new AssertionError(detailMessage);
            }
        };
        dsrCollectionRepositoryManager.removeByObject();
    }
}