//@Inject MittoApplication application; //this won't work

@Provides @Singleton
SharedPreferences provideSharedPreferences(Application application) { //this will
    return PreferenceManager.getDefaultSharedPreferences( application );
}