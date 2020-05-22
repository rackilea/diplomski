public class PersistentSetMapper implements CustomFieldMapper {

    private PersistentCollectionUtils mapperUtils = new PersistentCollectionUtils();

    @Override
    public boolean mapField(Object source, Object destination, Object sourceFieldValue, ClassMap classMap, FieldMap fieldMapping) {
        // return true => the field has been mapped, no need to map it further
        // return false => the field was not mapped, use downstream mappers

        // check if field is derived from Persistent Collection
        if (!mapperUtils.isAbstractPersistentCollection(sourceFieldValue)) {
            return false;
        }

        // check if field is already initialized
        if (mapperUtils.wasAbstractPersistentCollectionInitialized(sourceFieldValue)) {
            return false;
        } else {
            // if not initialized, try to initialize it
            boolean wasInitialized = mapperUtils.tryToInitializeCollection((Collection<?>) sourceFieldValue);
            if(wasInitialized) {
                return false;
            } else {
                destination = null;
                return true;
            }
        }
    }
}