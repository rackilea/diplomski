Observable<AuthResponse> mAuthSingleton = retrofit.authenticate()
    .doOnNext( response -> saveSessionToken(response.getSessionToken())
    .share();


Observable<AuthResponse> getAuthCallWhenNecessary(){
    if(sessionToken == null ||sessionToken.isAboutToExpire())
        return mAuthSingleton;
    else
        return Observable.just(new AuthResponse());
}

Observable<WhateverResponse> getWhatever(){
    return getAuthCallWhenNecessary().flatMap(response -> retrofit.getWhatever());
}