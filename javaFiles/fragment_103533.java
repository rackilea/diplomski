public class MainActivity extends AppCompatActivity {

ArrayList<NewsItems>myData=new ArrayList<>(); //No need for static

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ReadRss readRss = new ReadRss(this,myData); //Pass the list variable reference into the asynctask instance
    readRss.execute();
   Log.d("TAG", String.valueOf(myData.size()));//This will be empty due to concurrent call to asynctask, which executes parallel to main thread.
}


public void getData(ArrayList<NewsItems>items){//Static qualifier unneccessary here
    for (int i=0; i<items.size(); i++){
        myData.add(items.get(i));
    }
}
class ReadRss extends AsyncTask<Void, Void, Void>{

     ArrayList<NewsItems>feedItems = new ArrayList<>();
    Context context;
    String address = "http://www.thedailystar.net/frontpage/rss.xml";
    ProgressDialog progressDialog;
    URL url;

    public ReadRss(Context context,ArrayList<NewsItems> feedItems) {
        this.context = context;
        this.feedItems = feedItems; //Assign the reference of the list here so that modifications done within the Asynctask are reflected in the MainActivity
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
    }

    @Override
    protected void onPreExecute() {
        if(progressDialog!=null){
            if (!progressDialog.isShowing()){
                progressDialog.show();
            }
        }
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(progressDialog!=null){
            if (progressDialog.isShowing()){
                progressDialog.hide();
            }


        }
   //Do whatever you need with the arraylist data here
        getData(feedItems);
    }

    @Override
    protected Void doInBackground(Void... params) {
        ProcessXml(Getdata());
        return null;
    }