protected void onPostExecute(ArrayList<String> s) {
    super.onPostExecute(s);

       Log.i("###",s.toString());
               listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       Log.i("###", "BEFORE");
                       itemOne = (String) parent.getItemAtPosition(position); //null
                       Log.i("###AFTER", itemOne);
                   }
               });


    }