@Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        if (pDialog.isShowing())
            pDialog.dismiss();

        final ListAdapter adapter = new SimpleAdapter(GetLead.this, contactList, R.layout.list_item, new String[]{TAG_ID, TAG_NAME, TAG_ADDRESS, TAG_VARTYPE, priority}, new int[]{R.id.custId,
                R.id.name, R.id.address, R.id.verificationType});

        if (priority.equals("high")) {
            GetLead.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setListAdapter(adapter);
                    getListView().setBackgroundColor(getResources().getColor(R.color.colorAccent));
                }
            });
        }
    }