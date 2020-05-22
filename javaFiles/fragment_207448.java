/**
 * Get a reference to the ApplicationData object
 * @return ApplicationData
 * @throws IllegalStateException May be thrown if this method is called
 *  outside of a request and the ApplicationData object needs to be
 *  obtained via the FacesContext
 */
private ApplicationData getApplicationData() {
    if (_applicationData == null) {
        _applicationData = JSFUtilities.getManagedBean(
            "applicationData",  // name of managed bean
            ApplicationData.class);
        if (_applicationData == null) {
            throw new IllegalStateException(
                "Cannot get reference to ApplicationData object");
        }
    }
    return _applicationData;
}