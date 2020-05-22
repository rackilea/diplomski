serviceRetrofit.getContacts()
            .map(result -> serviceRetrofit.throwExceptionIfFailure(result))
            .map(result -> createOrUpdateContact(result))
            .retry(4)
            .onErrorReturn(error -> handleErrorEvent(error))
            .doOnCompleted(() -> emitStoreChange(new Store.StoreChangeEvent()))
            .subscribe();