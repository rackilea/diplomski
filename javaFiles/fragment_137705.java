public class Singlehistory extends Activity {

private ProgressDialog pDialog;

JSONParser jsonParser = new JSONParser();
JSONArray history = null;

String patient_id = null;
String remarks_id = null;

String date, diagnosis, medication, description;
private static final String SINGLE_HISTORY = "http://192.168.43.15:8080/DoctorScheduler/activities/singlehistory.php";

//json node
private static final String TAG_DATE        = "date";
private static final String TAG_DIAGNOSIS   = "diagnosis";
private static final String TAG_MEDICATION  = "medication";
private static final String TAG_DESC        = "description";
private static final String TAG_POST        = "post";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_singlehistory);

    Intent i = getIntent();
    patient_id = i.getStringExtra("patient_id");
    remarks_id = i.getStringExtra("remarks_id");

    new LoadSingleHistory().execute();
}

class LoadSingleHistory extends AsyncTask<String, String, String>{

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        pDialog = new ProgressDialog(Singlehistory.this);
        pDialog.setMessage("Loading patient information ...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... args) {
        // TODO Auto-generated method stub
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        // post patient id, remarks id as GET parameters
        params.add(new BasicNameValuePair("patient_id", patient_id));
        params.add(new BasicNameValuePair("remarks_id", remarks_id));

        // getting JSON string from URL
        String json = jsonParser.getJSONFromURL(SINGLE_HISTORY, "GET", params);

        // Check your log cat for JSON response
        Log.d("Single History JSON: ", json);

        try {
            JSONObject jObj = new JSONObject(json);
            if(jObj != null){

                history = jObj.getJSONArray(TAG_POST);
                if(history != null){

                    for(int i=0; i<history.length(); i++){
                    JSONObject c = history.getJSONObject(i);

                    date = c.getString(TAG_DATE);
                    diagnosis = c.getString(TAG_DIAGNOSIS);
                    medication = c.getString(TAG_MEDICATION);                   
                    description = c.getString(TAG_DESC);

                    }
                }
            }   
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        pDialog.dismiss();

        TextView Date        = (TextView) findViewById(R.id.txtDate);
        TextView Diagnosis   = (TextView) findViewById(R.id.txtDiagnosis);
        TextView Medication  = (TextView) findViewById(R.id.txtMedication);
        TextView Description = (TextView) findViewById(R.id.txtDescription);

        Date.setText(date);
        Diagnosis.setText(diagnosis);
        Medication.setText(medication);
        Description.setText(description);

        setTitle(TAG_DESC);

    }   
}