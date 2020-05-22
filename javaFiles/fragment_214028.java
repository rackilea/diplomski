public interface BusinessReferenceRepository<T> {
    Optional<T> getByBusinessReference(BusinessReference businessReference);

    default Optional<T> getByBusinessReference(String referenceId) {
        return getByBusinessReference(new BusinessReference(referenceId));
    }
}