public class Googlemap extends Activity implements SetOnLocationFoundListner {

       Activity activity;
       Context context;
        GoogleMap googleMap;
       double lat, lng;
       MapFragment temp;
      LatLng startLatLng;
     LatLng endLatLng;
      Polyline line = null;
        @Override
1        protected void onCreate(Bundle savedInstanceState) {   // TODO Auto-generated method stub
            ActionBar actionbar= getActionBar();
            actionbar.setTitle("REQUEST");
            super.onCreate(savedInstanceState);
            setContentView(R.layout.viv8);

            context = Googlemap.this;
            activity = Googlemap.this;
            initGMap();         // Initializing google map by calling method defined bellow(no. 2)


            String urlTopass = makeURL(startLatLng.latitude,    //using makeurl method defined below(no. 8) to create url for json parsing
                    startLatLng.longitude, endLatLng.latitude,
                    endLatLng.longitude);
            new connectAsyncTask(urlTopass).execute();                  //calling the class formed below(no 4) and passing the formed url


        }

2        public void initGMap() {                           //Initializing the google map method called above

            temp = (MapFragment) activity.getFragmentManager().findFragmentById(
                    R.id.map);
            if (googleMap == null)
                googleMap = temp.getMap();
            googleMap.getUiSettings().setZoomControlsEnabled(false);
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);
            googleMap.setMyLocationEnabled(true);
            new GetCurLocation(activity, 0, false, googleMap, this);            //Get current location class called defined below(no. 15)

        }

        @Override
3        public void onLocationFound(Location location, boolean getLocRegularly,    //for placing lat and lon of location to latling class
                GoogleMap gmap) {

            lat = location.getLatitude();
            lng = location.getLongitude();
            CameraUpdate cm = CameraUpdateFactory.newLatLngZoom(
                    new LatLng(lat, lng), 13);
            googleMap.animateCamera(cm);
        }


4        private class connectAsyncTask extends AsyncTask<Void, Void, String> {     //ConnectAsyncTask class
            private ProgressDialog progressDialog;
            String url;

            connectAsyncTask(String urlPass) {                      //putting value of urlPass variable from previous class 
                url = urlPass;
            }

            @Override
5            protected void onPreExecute() {                        //MEthod to display message while json parsing is done
                // TODO Auto-generated method stub
                super.onPreExecute();
                progressDialog = new ProgressDialog(context);
                progressDialog.setMessage("Fetching route, Please wait...");
                progressDialog.setIndeterminate(true);
                progressDialog.show();
            }

            @Override
6           protected String doInBackground(Void... params) {               //method for json parsing through url passed to class
                JSONParser jParser = new JSONParser();
                String json = jParser.getJSONFromUrl(url);              //Calling json parsing class(no 9) and passing url variable
                return json;
            }

            @Override
7            protected void onPostExecute(String result) {              //method to hide the message after the json parsing is done
                super.onPostExecute(result);
                progressDialog.hide();
                if (result != null) {
                    drawPath(result);                           //after json parsing drawing the route
                }
            }
        }

8        public String makeURL(double sourcelat, double sourcelog, double destlat,  //method to create url and retuen
                double destlog) {
            StringBuilder urlString = new StringBuilder();
            urlString.append("http://maps.googleapis.com/maps/api/directions/json");
            urlString.append("?origin=");// from
            urlString.append(Double.toString(sourcelat));
            urlString.append(",");
            urlString.append(Double.toString(sourcelog));
            urlString.append("&destination=");// to
            urlString.append(Double.toString(destlat));
            urlString.append(",");
            urlString.append(Double.toString(destlog));
            urlString.append("&sensor=false&mode=driving&alternatives=true");
            return urlString.toString();
        }

9       public class JSONParser {                           //json parser class to retrieve data from url

            InputStream is = null;
            JSONObject jObj = null;
            String json = "";

            // constructor
            public JSONParser() {
            }

            public String getJSONFromUrl(String url) {                  //method to fetch data from url by json parsing

                // Making HTTP request
                try {
                    // defaultHttpClient
                    DefaultHttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(url);

                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    HttpEntity httpEntity = httpResponse.getEntity();
                    is = httpEntity.getContent();

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }

                    json = sb.toString();
                    is.close();
                } catch (Exception e) {
                    Log.e("Buffer Error", "Error converting result " + e.toString());
                }
                return json;

            }
        }

10        public void drawPath(String result) {                     //method to draw route on google map

            if (line != null) {
                googleMap.clear();
            }
            googleMap.addMarker(new MarkerOptions().position(endLatLng).icon(       //to form marker at the end
                    BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            googleMap.addMarker(new MarkerOptions().position(startLatLng).icon(     //to form marker at the beg
                    BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            try {                                   //draw a polyline between end & beg         
                // Tranform the string into a json object
                final JSONObject json = new JSONObject(result);
                JSONArray routeArray = json.getJSONArray("routes");
                JSONObject routes = routeArray.getJSONObject(0);
                JSONObject overviewPolylines = routes
                        .getJSONObject("overview_polyline");
                String encodedString = overviewPolylines.getString("points");
                List<LatLng> list = decodePoly(encodedString);

                for (int z = 0; z < list.size() - 1; z++) {
                    LatLng src = list.get(z);
                    LatLng dest = list.get(z + 1);
                    line = googleMap.addPolyline(new PolylineOptions()
                            .add(new LatLng(src.latitude, src.longitude),
                                    new LatLng(dest.latitude, dest.longitude))
                            .width(5).color(Color.BLUE).geodesic(true));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

11        private List<LatLng> decodePoly(String encoded) {             //method to form polyline between end & beg

            List<LatLng> poly = new ArrayList<LatLng>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;

            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;

                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lng += dlng;

                LatLng p = new LatLng((((double) lat / 1E5)),
                        (((double) lng / 1E5)));
                poly.add(p);
            }

            return polyine
    }`enter code here
    {`   
12    public class GetCurLocation implements LocationListener,              //class called above
            GooglePlayServicesClient.ConnectionCallbacks,
            GooglePlayServicesClient.OnConnectionFailedListener {

        public static LocationClient mLocationClient;
        LocationRequest mLocationRequest;
        public static LocationManager locationmanager;
        float accuracy = 500;
        Activity context;
        boolean getLocRegularly = false;
        int interval = 1000;
        GoogleMap gmap;

        SetOnLocationFoundListner OLF;

13        public interface SetOnLocationFoundListner {
            public void onLocationFound(Location location, boolean getLocRegularly,
                    GoogleMap gmap);
        }

14        public void RemoveUpdates() {
            try {
                if (mLocationClient != null)
                    mLocationClient.removeLocationUpdates(this);
                if (locationmanager != null)
                    locationmanager.removeUpdates(LocUpByLocMgr);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

15        public GetCurLocation(Activity activity, int interval,            //CONSTRUCTOR WHERE THE Value passed from above(no 2) goes
                boolean getLocRegularly, GoogleMap gmap,
                SetOnLocationFoundListner OLF) {
            this.OLF = OLF;
            this.gmap = gmap;
            this.context = activity;
            this.getLocRegularly = getLocRegularly;
            this.interval = interval;
            if (servicesConnected()) {
                mLocationClient = new LocationClient(context, this, this);
                mLocationClient.connect();
                mLocationRequest = LocationRequest.create();
                mLocationRequest.setInterval(interval);
                mLocationRequest
                        .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                mLocationRequest.setFastestInterval(interval);
            }

            locationmanager = (LocationManager) context
                    .getSystemService(Context.LOCATION_SERVICE);
            Criteria cr = new Criteria();
            String provider = locationmanager.getBestProvider(cr, true);
            locationmanager.requestLocationUpdates(provider, interval, 0,
                    LocUpByLocMgr);
        }

16        private boolean servicesConnected() {
            int resultCode = GooglePlayServicesUtil
                    .isGooglePlayServicesAvailable(context);
            if (ConnectionResult.SUCCESS == resultCode) {
                return true;
            } else {
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode,
                        (Activity) context, 0);
                if (dialog != null) {
                }
                return false;
            }
        }

        @Override
        public void onConnectionFailed(ConnectionResult result) {

        }

        @Override
        public void onConnected(Bundle connectionHint) {
            try {
                mLocationClient.requestLocationUpdates(mLocationRequest, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onDisconnected() {
        }

        @Override
17        public void onLocationChanged(Location location) {                //previous location is passed in here to check 
            try {                                   //if its equal to current location or not
                if (location.getAccuracy() > 2000) {
                    Log.e("testing LC", location.getAccuracy()
                            + " Its Not Accurate");
                } else {
                    Log.e("testing LC", location.getAccuracy() + " Its Accurate");
                    try {
                        OLF.onLocationFound(location, getLocRegularly, gmap);
                        if (!getLocRegularly) {
                            mLocationClient.removeLocationUpdates(this);
                            locationmanager.removeUpdates(LocUpByLocMgr);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        android.location.LocationListener LocUpByLocMgr = new android.location.LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderEnabled(String provider) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderDisabled(String provider) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onLocationChanged(Location location) {

                try {
                    if (location.getAccuracy() > 2000) {
                        Log.e("testing LM", location.getAccuracy()
                                + " Its Not Accurate");
                    } else {
                        Log.e("testing LM", location.getAccuracy()
                                + " Its Accurate");

                        try {
                            OLF.onLocationFound(location, getLocRegularly, gmap);
                            if (!getLocRegularly) {
                                mLocationClient
                                        .removeLocationUpdates(GetCurLocation.this);
                                locationmanager.removeUpdates(LocUpByLocMgr);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

    }

18    }`public class Draw_route {                           //class to showing all the data related to the location
        public final static String MODE_DRIVING = "driving";                //like driving path,walking route
        public final static String MODE_WALKING = "walking";

        public Draw_route() { }

        public Document getDocument(LatLng start, LatLng end, String mode) {        //getting all the details of the route like 
            String url = "http://maps.googleapis.com/maps/api/directions/xml?"      //location,duration according to mode driving or walking,distance
                    + "origin=" + start.latitude + "," + start.longitude 
                    + "&destination=" + end.latitude + "," + end.longitude
                    + "&sensor=false&units=metric&mode=driving";

            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext localContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost(url);
                HttpResponse response = httpClient.execute(httpPost, localContext);
                InputStream in = response.getEntity().getContent();
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.parse(in);
                return doc;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public String getDurationText (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("duration");
            Node node1 = nl1.item(0);
            NodeList nl2 = node1.getChildNodes();
            Node node2 = nl2.item(getNodeIndex(nl2, "text"));
            Log.i("DurationText", node2.getTextContent());
            return node2.getTextContent();
        }

        public int getDurationValue (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("duration");
            Node node1 = nl1.item(0);
            NodeList nl2 = node1.getChildNodes();
            Node node2 = nl2.item(getNodeIndex(nl2, "value"));
            Log.i("DurationValue", node2.getTextContent());
            return Integer.parseInt(node2.getTextContent());
        }

        public String getDistanceText (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("distance");
            Node node1 = nl1.item(0);
            NodeList nl2 = node1.getChildNodes();
            Node node2 = nl2.item(getNodeIndex(nl2, "text"));
            Log.i("DistanceText", node2.getTextContent());
            return node2.getTextContent();
        }

        public int getDistanceValue (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("distance");
            Node node1 = nl1.item(0);
            NodeList nl2 = node1.getChildNodes();
            Node node2 = nl2.item(getNodeIndex(nl2, "value"));
            Log.i("DistanceValue", node2.getTextContent());
            return Integer.parseInt(node2.getTextContent());
        }

        public String getStartAddress (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("start_address");
            Node node1 = nl1.item(0);
            Log.i("StartAddress", node1.getTextContent());
            return node1.getTextContent();
        }

        public String getEndAddress (Document doc) {
            NodeList nl1 = doc.getElementsByTagName("end_address");
            Node node1 = nl1.item(0);
            Log.i("StartAddress", node1.getTextContent());
            return node1.getTextContent();
        }



        public ArrayList<LatLng> getDirection (Document doc) {
            NodeList nl1, nl2, nl3;
            ArrayList<LatLng> listGeopoints = new ArrayList<LatLng>();
            nl1 = doc.getElementsByTagName("step");
            if (nl1.getLength() > 0) {
                for (int i = 0; i < nl1.getLength(); i++) {
                    Node node1 = nl1.item(i);
                    nl2 = node1.getChildNodes();

                    Node locationNode = nl2.item(getNodeIndex(nl2, "start_location"));
                    nl3 = locationNode.getChildNodes();
                    Node latNode = nl3.item(getNodeIndex(nl3, "lat"));
                    double lat = Double.parseDouble(latNode.getTextContent());
                    Node lngNode = nl3.item(getNodeIndex(nl3, "lng"));
                    double lng = Double.parseDouble(lngNode.getTextContent());
                    listGeopoints.add(new LatLng(lat, lng));

                    locationNode = nl2.item(getNodeIndex(nl2, "polyline"));
                    nl3 = locationNode.getChildNodes();
                    latNode = nl3.item(getNodeIndex(nl3, "points"));
                    ArrayList<LatLng> arr = decodePoly(latNode.getTextContent());
                    for(int j = 0 ; j < arr.size() ; j++) {
                        listGeopoints.add(new LatLng(arr.get(j).latitude, arr.get(j).longitude));
                    }

                    locationNode = nl2.item(getNodeIndex(nl2, "end_location"));
                    nl3 = locationNode.getChildNodes();
                    latNode = nl3.item(getNodeIndex(nl3, "lat"));
                    lat = Double.parseDouble(latNode.getTextContent());
                    lngNode = nl3.item(getNodeIndex(nl3, "lng"));
                    lng = Double.parseDouble(lngNode.getTextContent());
                    listGeopoints.add(new LatLng(lat, lng));
                }
            }

            return listGeopoints;
        }

19        private int getNodeIndex(NodeList nl, String nodename) {
            for(int i = 0 ; i < nl.getLength() ; i++) {
                if(nl.item(i).getNodeName().equals(nodename))
                    return i;
            }
            return -1;
        }

20        private ArrayList<LatLng> decodePoly(String encoded) {
            ArrayList<LatLng> poly = new ArrayList<LatLng>();
            int index = 0, len = encoded.length();
            int lat = 0, lng = 0;
            while (index < len) {
                int b, shift = 0, result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
                lat += dlat;
                shift = 0;
                result = 0;
                do {
                    b = encoded.charAt(index++) - 63;
                    result |= (b & 0x1f) << shift;
                    shift += 5;
                } while (b >= 0x20);
                int dlng = ((result & 1) != 0 ? ~(result >> 1) : (re`enter code here`sult >> 1));
                lng += dlng;

                LatLng position = new LatLng((double) lat / 1E5, (double) lng / 1E5);
                poly.add(position);
            }
            return poly;
        }