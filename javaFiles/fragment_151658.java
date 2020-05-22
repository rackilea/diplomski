public class fetchdata extends AsyncTask<Void,Void,Void> {
        String data="";
        String dataparsed="";
        String singleparsed="";
        List<Entry> x;
        List<String> y;
        boolean flag=false;

        private WeakReference<Context> contextRef;

        public fetchdata(Context context) {
            contextRef = new WeakReference<>(context);
        } 


        @Override
        protected Void doInBackground(Void... voids) {

            x = new ArrayList<Entry>();
            y = new ArrayList<String>();
            try {
                URL url=new URL("https://io.adafruit.com/api/v2/Yarev/feeds/pir-sensor/data");
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String line="";
                while (line!=null)
                {
                    line=bufferedReader.readLine();
                    data=data+line;
                }
                JSONArray JA=new JSONArray(data);
                for(int i=0;i<JA.length();i++)
                {
                    JSONObject JO= (JSONObject) JA.get(i);
                    singleparsed="Value:"+JO.get("value")+"\n"+
                            "Feed key:"+JO.get("feed_key")+"\n"+
                            "Created:"+JO.get("created_at")+"\n";
                    int value=JO.getInt("value");
                    float v1=value;
                    x.add(new Entry(i,v1));
                    dataparsed=dataparsed+singleparsed;
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);

           if (context != null) {
            // start new activity with context
             Intent intent=new Intent(context,NewActivity.class);
             context.startActivity(intent);
           }


        }
        public List<Entry> getList() {
            return x;
        }

    }