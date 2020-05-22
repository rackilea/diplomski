@Module(
        library = true,
        complete = false)
public class SessionDomainModule {

    // TODO: Rethink this implementation.
    @Provides
    public Session provideSession(Application application) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(application);
        String sessionJString = preferences.getString(AppConfig.PREF_KEY_CURRENT_SESSION, "");

        Session session;
        if(!"".equals(sessionJString)) {
            return new Gson().fromJson(sessionJString, Session.class);
        }

        return null;
    }
    ...
}