public class chronos extends IntentService {

    int happiness;
    public chronos() {
        super("chronos");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO Auto-generated method stub

        SharedPreferences settings = getSharedPreferences("APP_PREFS",
                MODE_PRIVATE);

            happiness = settings.getInt("HAPPINESS",0) - 1;

            SharedPreferences.Editor prefEditor = settings.edit();
            prefEditor.putInt("HAPPINESS",happiness);
            prefEditor.commit();

        Toast.makeText(getBaseContext(),
                "Chronos running" + settings.getInt("HAPPINESS", 0),
                Toast.LENGTH_LONG).show();

    }

}