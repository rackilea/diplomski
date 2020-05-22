@Override
public void onRequestFailure(SpiceException e) {
    ....
    spiceManager.removeDataFromCache(AccessTokenResponse.class);
    ....
}

@Override
public void onRequestSuccess(AccessTokenResponse accessToken) {
    if (accessToken == null) {
        return;
    }
    ....
    spiceManager.removeDataFromCache(AccessTokenResponse.class);
    ....
}