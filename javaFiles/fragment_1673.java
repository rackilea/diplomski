class yourAsyncTask extends AsyncTask<String, String, String> {

    String brand_id;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public yourAsyncTask(String brand_id)//change argument type accordingly
    {
       this.brand_id=brand_id;
    }
      //use brand_id as a parameter value
}