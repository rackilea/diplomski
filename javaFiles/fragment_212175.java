public Observable<List<Profile>> getProfiles() {

    return Observable.defer(new Func0<Observable<List<Profile>>>() {
        @Override
        public Observable<List<Profile>> call() {

            if (mApi == null) {
                BirthpayApi.Builder builder = new BirthpayApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                mApi = builder.build();
            }

            try {
                List<Profile> profiles = mApi.getFriends(mUserId).execute().getItems();
                return Observable.just(profiles);
            } catch (IOException e) {
                return Observable.error(e);
            }
        }
    });
}