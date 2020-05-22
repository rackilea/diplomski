@Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            prog.dismiss();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,aa);
            setContentView(R.layout.activity_main);
            lv = (ListView) findViewById(R.id.listView1);
            lv.setAdapter(adapter);