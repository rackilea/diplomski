public class Action extends AsyncTask<Void, Void,Void>{  private final Context context;
    public Action(Context context){
        this.context = context;
    }

    @Override
    protected Intent doInBackground(Void params) {
        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps");
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        context.startActivity(intent)


  return null;
 }
}