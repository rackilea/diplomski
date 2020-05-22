@Override
protected void onPreExecute() {
    super.onPreExecute();
    pDialog = new ProgressDialog(Cinema.this);
    pDialog.setMessage("Carregando...");
    pDialog.setCancelable(false);
    pDialog.show();

    listaDados = new ArrayList<HashMap<String, String>>();
}