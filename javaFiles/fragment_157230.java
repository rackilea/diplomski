String Yesterday , Today , Tomorrow = " ; //Define inside your class , outside of any method or code block,

        @Override
        protected Void doInBackground(Void... arg0){
            HttpHandler sh = new HttpHandler();
            //faccio una richiesta al server e attendo risposta
            String jsonStr = sh.makeServiceCall(url); 
            Log.e("RAW-JSON: ","Retrieve RAW-Json is "+jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    String DATESTRING = jsonObj.getString("date");

                    JSONObject DATE = new JSONObject(DATESTRING); //Log.d("STAMPA","DATESTRING"+DATESTRING);

                    //Log.d("PER FAVORE","IERI ERA "+Ieri);
                    //ESTRAGGO E INSERISCO DOVE MI SERVE
                    Yesterday = DATE.getString("ieri");
                    Today = DATE.getString("oggi");
                   Tomorrow = DATE.getString("domani");
                } catch (JSONException e) {
                    runOnUiThread(new Runnable(){
                        @Override
                        public void run(){
                            Toast.makeText(getContext(),"Errore nel recupero dati",Toast.LENGTH_LONG).show();
                        }
                    });
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            //tolgo il caricamento di pDialog
            if (pDialog.isShowing())
                pDialog.dismiss();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new YesterdayFragment(),Yesterday );  //i can set from here the name of tabs but how if the name from by Json?
        adapter.addFragment(new TodayFragment(), Today);
        adapter.addFragment(new TomorrowFragment(), Tomorrow);
        viewPager.setAdapter(adapter);
    }