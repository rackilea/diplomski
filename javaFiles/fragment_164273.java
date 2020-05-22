public class Action extends AsyncTask<URI, Void, Intent> {
    private final Context context;
    public Action(Context context){
        this.context = context;
    }

    @Override
    protected Intent doInBackground(URI... params) {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    @Override
    protected void onPostExecute(Intent intent){
        context.startActivity(intent);
    }
}