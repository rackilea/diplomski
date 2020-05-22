public class Account {

private static Account account;
private static final String ACCESS_TOKEN = "access_token";
public String accessToken;

public static Account getInstance() {
    if (account == null)
        account = new Account();
    return account;
}

public void save(Context context) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    Editor editor = prefs.edit();

    editor.putString(ACCESS_TOKEN, accessToken);

    editor.commit();
}

public void restore(Context context) {
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    accessToken = prefs.getString(ACCESS_TOKEN, accessToken);
}

private Account() {

}
}