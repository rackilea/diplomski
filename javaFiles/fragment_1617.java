private static String SOAP_ACTION = "http://tempuri.org/METHOD_NAME";
private static String NAMESPACE = "http://tempuri.org/";
private static String METHOD_NAME = "METHOD_NAME";
private static String URL = "myurl.com";

Button button1;
TextView textView1;
String jsonStr;

ListView listView1 =(ListView) findViewById(R.id.idlistView1);


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    StrictMode.setThreadPolicy(policy);

    button1 =(Button) findViewById(R.id.idbutton1);
    textView1 = (TextView) findViewById(R.id.idtxtView1);

    button1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            //Initialize soap request + add parameters
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            //Use this to add parameters
            request.addProperty("id_no", 123
            request.addProperty("serial_no", 2);
            request.addProperty("Year", 2017);
            request.addProperty("Username", "username");
            request.addProperty("Password", "password");

            //Declare the version of the SOAP request
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

            envelope.setOutputSoapObject(request);
            envelope.dotNet = true;

            try {
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                //this is the actual part that will call the webservice
                androidHttpTransport.call(SOAP_ACTION, envelope);

                // Get the SoapResult from the envelope body.
                SoapPrimitive resultsRequestSOAP = (SoapPrimitive) envelope.getResponse();
                jsonStr = resultsRequestSOAP.toString();
                textView1.setText(jsonStr);


            } catch(Exception E) {

               xy = ("ERROR:" + E.getClass().getName() + ": " + E.getMessage());

            }
            if (xy != null) {
                    try {
                        // JSONObject jsonObj = new JSONObject(xy);

                        // Getting JSON Array node
                        JSONArray contacts = new JSONArray(xy);

                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);

                            String sroname = c.getString("name");
                            String docnumber = c.getString("idnumber");
                            String ariclename = c.getString("surname");
                            String areaname = c.getString("areaname");
                            String consideration_amt = c.getString("state");
                            String marketvalue = c.getString("country");
                            String stampdutypaid = c.getString("registrationfees");

                            // Phone node is JSON Object

                            // tmp hash map for single contact
                            HashMap<String, String> contact = new HashMap<>();

                            // adding each child node to HashMap key => value
                            contact.put("name","Name:   "+ name);
                            contact.put("idnumber","Id Number:   "+ idnumber);
                            contact.put("surname","Surname:   "+ surname);
                            contact.put("areaname","Area Name:   "+ areaname);
                            contact.put("state","State:   "+ state);
                            contact.put("country","Country:   "+ country);
                            contact.put("registrationfees","Registration Fees:   "+ registrationfees);

                            // adding contact to contact list
                            docdetails.add(contact);
                        }
                    }
                    catch(JSONException e)
                    {
                        String error = ("Json parsing error: "  + e.getMessage());
                        Toast.makeText(getApplicationContext(),error,Toast.LENGTH_LONG).show();

                    }
                } else
                {
                    String error = ("Couldn't get json from server. ");
                    Toast.makeText(getApplicationContext(),error,Toast.LENGTH_SHORT).show();
                }
                /**
                 * Updating parsed JSON data into ListView
                 * */

                ListAdapter adapter = new SimpleAdapter(WebResponce.this, docdetails,R.layout.list_item, new String[]{"name","idnumber","surname","areaname","state","country","registrationfees"},
                        new int[]{R.id.idname,R.id.ididnumber,R.id.idsurname, R.id.idareaname,R.id.idstate,R.id.idcountry,R.id.idregistrationfees});
                listView11.setAdapter(adapter);

        }
    });

}