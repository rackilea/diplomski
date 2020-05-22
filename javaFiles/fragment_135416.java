// Interface for bserving
    public interface DownloadListsner{
        public void onSuccess(String uri);
        public void onError(String uri);
    }
    // API for submitting download request
    public void saveRemoteFile(String url, String filename,DownloadListsner listener... ){

        ...
    }

    AsyncTask{
        // Upon finish execution
        onPostExecute(){

// Take action
            listener.onSuccess

            or 

            listener.onError
        }
    }