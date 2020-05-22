public class MyAppCompatActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, LocaleHelper.LOCALE_DEFAULT_LANG));
    }

}