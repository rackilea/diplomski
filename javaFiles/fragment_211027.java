private ObservableTransformer<RxBleConnection, RxBleConnection> mtuNegotiationObservableTransformer = upstream -> {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        return upstream.doOnSubscribe(ignoredDisposable -> Log.i("MTU", "MTU negotiation is not supported")); // added a closing bracket here
    }

    return upstream
            .doOnSubscribe(ignoredDisposable -> Log.i("MTU", "MTU negotiation is supported")) // and here
                    .flatMapSingle(connection ->
                            connection.requestMtu(GATT_MTU_MAXIMUM)
                                    .doOnSubscribe(ignoredDisposable -> Log.i("MTU", "Negotiating MTU started"))
                                    .doOnSuccess(mtu -> Log.i("MTU", "Negotiated MTU: " + mtu))
                                    .ignoreElement()
                                    .andThen(Single.just(connection)));
};