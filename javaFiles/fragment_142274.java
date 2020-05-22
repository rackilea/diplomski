class TheTask extends AsyncTask<Void,Void,Void>
{

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub
           try {
                wrapper = new ApiWrapper("client_id",
                         "client_secret",
                         null,
                         null);
                token = wrapper.login("username", "password");
                upload();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return null;
    }

}