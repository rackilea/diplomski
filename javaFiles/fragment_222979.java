public class LocationAsyncTask extends AsyncTask {

    private ArrayList<Location> locationList;
    private final WeakReference<ListView> listViewWeakReference;

    private Context context;

    public LocationAsyncTask(ListView listView, Context context) {
        this.listViewWeakReference = new WeakReference<>(listView);
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            //These lines are an example(I will obtain the data via internet)
            Location ejemplo = new Location("Locality1s", "name", "address");
            Location ejemplo2 = new Location("Locality2", "name2", "address2");
            locationList = new ArrayList<Location>();
            locationList.add(ejemplo);
            locationList.add(ejemplo2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        ArrayAdapter<Location> adapter = new CustomLocationAdapter(context, locationList);
        listViewWeakReference.get().setAdapter(adapter);
    }
}