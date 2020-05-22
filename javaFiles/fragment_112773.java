class Query extends AsyncTask<Void, Void, Void> {
  @Override
  protected String doInBackground(String... args) {
    CloudQuery query = new CloudQuery("Messages");
    try {
        query.find(new CloudObjectArrayCallback(){
            @Override
            public void done(CloudObject[] x, CloudException t) {
                if(x != null){
                    Log.d("dozer74", "====>>>> x is not equal to null");
                } else {
                    Log.d("dozer74", "====>>>> x is equal to null");
                }

                if(t != null){
                    Log.d("dozer74", "====>>>> t is not equal to null");
                } else {
                    Log.d("dozer74", "====>>>> t is equal to null");
                }
            }
        });
    } catch (CloudException e) {
        e.printStackTrace();
    }


   return null;
  }

 }