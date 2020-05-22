swipeRefreshLayout.post(new Runnable() {
        @Override
        public void run() {
            swipeRefreshLayout.setRefreshing(true);

            // Showing progress dialog
            final ProgressDialog pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

            contactList.clear();

            new GetContacts() {

              @Override
              protected void onPostExecute(Void result) {
                  // stopping swipe refresh
                  swipeRefreshLayout.setRefreshing(false);

                  // Dismiss the progress dialog
                  if (pDialog.isShowing())
                      pDialog.dismiss();

                  ListAdapter adapter = new SimpleAdapter(
                  MainActivity.this, contactList, R.layout.list_item, 
                  new String[]{"kw", "kva", "pf"}, 
                  new int[]{R.id.kw,R.id.kva, R.id.pf});

                  lv.setAdapter(adapter);  

                }
            }.execute();
        }
    }
);