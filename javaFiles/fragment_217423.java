@Override
protected void onPreExecute() {
    super.onPreExecute();
    //show progress bar here

}

@Override
protected Void doInBackground(Void... params) {
    //Do heavy work here
    return null;
}
@Override
protected void onPostExecute(Void result) {

    super.onPostExecute(result);

    //Dissmiss the dialgo
    //call m_adapter.setList(m_orders)
}