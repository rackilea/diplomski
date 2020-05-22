private class PrepareAdapter1 extends AsyncTask<Void,Void,ContactsListCursorAdapter > {
    ProgressDialog dialog;
    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(viewContacts.this);
        dialog.setMessage(getString(R.string.please_wait_while_loading));
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
    }
    /* (non-Javadoc)
     * @see android.os.AsyncTask#doInBackground(Params[])
     */
    @Override
    protected ContactsListCursorAdapter doInBackground(Void... params) {
        cur1 = objItem.getContacts();
        startManagingCursor(cur1);

        adapter1 = new ContactsListCursorAdapter (viewContacts.this,
                R.layout.contact_for_listitem, cur1, new String[] {}, new int[] {});

        return adapter1;
    }

    protected void onPostExecute(ContactsListCursorAdapter result) {
        list.setAdapter(result);
        dialog.dismiss();
    }
}