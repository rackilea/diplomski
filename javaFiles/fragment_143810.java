import org.hibernate.collection.internal.AbstractPersistentCollection;

public class PersistentCollectionUtils {
    public boolean isAbstractPersistentCollection(Object object) {
        return object instanceof AbstractPersistentCollection;
    }

    public boolean wasAbstractPersistentCollectionInitialized(Object collection) {
        return ((AbstractPersistentCollection) collection).wasInitialized();
    }

    public boolean isObjectSafeToUse(Object object) {
        return isAbstractPersistentCollection(object) ? 
                wasAbstractPersistentCollectionInitialized(object) :
                    true;
    }

    public boolean tryToInitializeCollection(Collection<?> collection) {
        if(collection != null) {
            try {
                collection.iterator().hasNext();
                return true;
            } catch (Exception t) {}
        }
        return false;
    }
}