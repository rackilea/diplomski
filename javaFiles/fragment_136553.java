public class AsyncTaskPost extends AsyncTask<URL, Void, Void> {

private IProfiler mProfilerActions;

public AsyncTaskPost(IProfiler profilerActions){
    mProfilerActions = profilerActions;
}

@Override
protected void onPreExecute() {
    super.onPreExecute();
    mProfilerActions.ShowProgressbar();
}

@Override
protected Void doInBackground(URL... urls) {
    try{
        Thread.sleep(5000);
        return null;
    }
    catch (Exception ex) {
        return null;
    }
}

@Override
protected void onPostExecute(Void aVoid) {
    mProfilerActions.HideProgressbar();
    mProfilerActions.MakeToast();
}

@Override
protected void onCancelled() {

    super.onCancelled();
    mProfilerActions.HideProgressbar();
}
}