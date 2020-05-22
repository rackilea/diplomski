public interface ValidationListener {

    public void validationFailed(DocumentFilter filter);

    public void validationPassed(DocumentFilter filter);
}