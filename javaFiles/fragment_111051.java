public class ParentAsyncTask extends AsyncTask... implements OnTaskCompletedListener{

    private int tasksRunning = 0;

    @Override
    protected LatLng doInBackground(...) {
        tasksRunning = clients.size();
        // spawn multiple AsyncTask
        for (ClientsDetailDAO clientsDetailDAO : clients) {
                Log.d(TAG, "onConnected for");
                Addresses addresses = clientsDetailDAO.getAddress();
                StringBuilder sb = null;
                if (addresses != null) {
                    Log.d(TAG, "onConnected address not null");
                    sb = new StringBuilder(addresses.getStreetAddress())
                            .append(", ").append(addresses.getCity())
                            .append(", ").append(addresses.getState())
                            .append(", ").append(addresses.getZip());
                    Log.d(TAG, "Address formatted: " + sb.toString());

                    mAddressAsyncTask = new GetAddressAsyncTask(
                            clientsDetailDAO);
                    mAddressAsyncTask.execute(sb.toString());

                }
        }
    }                     

    @Override
    void onTaskCompleted(...){
        tasksRunning--;
        if (tasksRunning == 0){
            doSomethingAfterAllTasksFinished();
        }           
    }

}