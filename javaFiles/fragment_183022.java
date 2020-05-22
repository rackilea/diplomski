class DemoClass extends AsyncTask<String, Void, String>
{

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub

        String result=getAppInformation();

        return result;
    }

}