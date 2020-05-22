@Singleton
@Provides
IAdverticumChecker provideAdverticumChecker(){
    return new AdverticumChecker(context);
}
...
public AdverticumChecker(Context context) {
    IndexApplication.getApplication().getAppComponent().inject(this);
}