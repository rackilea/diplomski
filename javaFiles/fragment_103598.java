public class CallServer extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        // Do your request to the server
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (result == SUCCESS) {
            // Display message to indicate successful request
            new UpdateDatabase().execute(params);
        } else {
            // Display error message or whatever you want to do 
        }
    }
}

public class UpdateDatabase extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        // Update the DB
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (result == SUCCESS) {
            // Display success message or whatever you want to do 
        } else {
            // Display error message or whatever you want to do 
        }
    }
}