public class DsrCollectionRepositoryManager /* Or whatever your class is called. */ {
    /* ... */

    public void removeByObject() {
        try {
            removeByObjectOrThrow();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    protected boolean /* or whatever your return type is */ removeByObjectOrThrow() {
        DsrCollection dsrCollection = new DsrCollection();
        dsrCollection.setNuId(180);
        return dsrCollectionRepository.remove(dsrCollection);
    }

    /* ... */
}