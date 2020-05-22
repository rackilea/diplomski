Observable<WeatherResult> weatherObservable = Observable.create(subscriber -> {
        Awareness.SnapshotApi.getWeather(client)
                .setResultCallback(weather -> {
                    if (!weather.getStatus().isSuccess()) {
                        subscriber.onError(new Exception("Could not get weather."));
                        Log.d(TAG, "Could not get weather");
                    } else {
                        //How do I do here?

                        subscriber.onNext(weather);
                        subscriber.onCompleted();
                    }
                });
    });

    Observable<LocationResult> locationObservable = Observable.create(subscriber -> {
        Awareness.SnapshotApi.getLocation(mGoogleApiClient)
                .setResultCallback(retrievedLocation -> {
                    if(!retrievedLocation.getStatus().isSuccess()) {
                        subscriber.onError(new Exception("Could not get location."));
                    } else {
                        Log.d("FRAG", retrievedLocation.getLocation().getLatitude() + "");
                        subscriber.onNext(retrievedLocation);
                        subscriber.onCompleted();
                    }
                });
    });