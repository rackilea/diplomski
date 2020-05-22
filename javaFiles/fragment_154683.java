public void init() {
    mAuthorizationRepository.getLoggedInUser();
}

public LiveData<Authorization> getLoggedInUserAuth() {
    return mAuthorizationRepository.getAuthorizationResult();
}