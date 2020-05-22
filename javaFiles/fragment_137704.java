public class History extends ListActivity{

private Button create, back;
private ProgressDialog pDialog;
private static final String READ_HISTORY_URL = "http://192.168.43.15:8080/DoctorScheduler/activities/history.php";

private static final String TAG_POST    = "post";
private static final String TAG_DATE    = "date";
private static final String TAG_DESC    = "description";
private static final String TAG_ID      = "remarks_id";

JSONParser jsonParser = new JSONParser();
JSONArray history = null;

String patient_id;
ArrayList<HashMap<String, String>> historyList;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_history);

    //get patient_id
    Intent i = getIntent();
    patient_id = i.getStringExtra("id");

    //hashmap for history listview
    historyList = new ArrayList<HashMap<String, String>>();

    new LoadHistory().execute();

    ListView lv = getListView();
    lv.setOnItemClickListener(new OnItemClickListener(){

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
            // TODO Auto-generated method stub
            // INSERT ALL PREVIOUS CONSULTATIONS OF THE PATIENT HERE
            Intent viewhistory = new Intent(History.this, Singlehistory.class);

            String pid = ((TextView) view.findViewById(R.id.txtPid)).getText().toString();
            String rid = ((TextView) view.findViewById(R.id.txtRid)).getText().toString();

            Toast.makeText(History.this, "patient_id: " + pid + ", remarks_id: " + rid, Toast.LENGTH_LONG).show();

            viewhistory.putExtra("patient_id", pid);
            viewhistory.putExtra("remarks_id", rid);

            startActivity(viewhistory);
        }
    });

    lv.setOnItemLongClickListener(new OnItemLongClickListener(){

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view,
                int position, long id) {
            // TODO Auto-generated method stub

            Intent edithistory = new Intent(History.this, Edithistory.class);

            String patient_id = ((TextView) view.findViewById(R.id.txtPid)).getText().toString();
            String remarks_id = ((TextView) view.findViewById(R.id.txtRid)).getText().toString();

            Toast.makeText(History.this, "p_id: " + patient_id + "r_id: " + remarks_id, Toast.LENGTH_LONG).show();

            edithistory.putExtra("patient_id", patient_id);
            edithistory.putExtra("remarks_id", remarks_id);

            startActivity(edithistory);
            return true;
        }
    });

    create = (Button) findViewById(R.id.Addhistory);
    create.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(History.this, Addhistory.class);
            String id = ((TextView) v.findViewById(R.id.txtRid)).getText().toString();
            i.putExtra("id", id);
            startActivity(i);
        }
    });

    back = (Button) findViewById(R.id.BtnBack);
    back.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

        }
    });

}

public void nextScreen(){

    Intent i = new Intent(History.this, Addhistory.class);
    String id = ((TextView) findViewById(R.id.txtRid)).getText().toString();
    i.putExtra("id", id);
    startActivity(i);
}

class LoadHistory extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();

        pDialog = new ProgressDialog(History.this);
        pDialog.setMessage("Loading all patient consultations....");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show(); 

    }

    @Override
    protected String doInBackground(String... args) {
        // TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("patient_id", patient_id));

        String json = jsonParser.getJSONFromURL(READ_HISTORY_URL, "GET", params);

        Log.d("Response: ", json);

        try{
            JSONObject jObj = new JSONObject(json);

            if(jObj!=null){

                history = jObj.getJSONArray(TAG_POST);

                if(history != null){
                    //looping through all patient's remarks
                    for(int i=0; i<history.length(); i++){
                    JSONObject c = history.getJSONObject(i);

                        //storing into json variable

                        //String id = c.getString(TAG_ID);
                        String remarks_id = c.getString(TAG_ID);
                        String date = c.getString(TAG_DATE);
                        String description = c.getString(TAG_DESC);

                        //creating new HashMap
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("patient_id", patient_id);
                        map.put(TAG_ID, remarks_id);
                        map.put(TAG_DATE, date);
                        map.put(TAG_DESC, description);

                        historyList.add(map);
                    }
                }else{
                    Log.d("History:", "null");
                }
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        //super.onPostExecute(result);
        pDialog.dismiss();

        ListAdapter adapter = new SimpleAdapter(
                History.this, historyList,  R.layout.mainhistory,
                new String[] {"patient_id", TAG_ID, TAG_DATE, TAG_DESC},
                new int[] {R.id.txtPid, R.id.txtRid, R.id.txtRdate, R.id.txtRdesc});

        setListAdapter(adapter);
    }
}