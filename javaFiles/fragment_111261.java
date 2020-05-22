private class GetCategoryAndProduct extends AsyncTask<String,Void,Void>  
{
    @Override
    protected Void doInBackground(String... params) {
        //Call Web Method
        data =(WebService.invokeCategory("getCategory",company_id,"0"));
        return null;
    }

    @Override
    //Once WebService returns response
    protected void onPostExecute(Void result) {
        //get server response here

        }
        }
    }
    @Override
    protected void onPreExecute() {

    }

}