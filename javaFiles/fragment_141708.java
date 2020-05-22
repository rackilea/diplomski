public class Gps extends IntentService {


    public Gps() {
        super("Gps");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("Testing","Testing");
    }
}