public TranslateAPI(Callbacks listener) {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    mService = retrofit.create(TranslateService.class);

    //this is the line you would add...
    this.listener = listener;
}