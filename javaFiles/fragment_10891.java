/**
 * Check if asynctask is running, if still running cancel it.
 */
public void forceCancel(){
    if (getStatus().equals(AsyncTask.Status.RUNNING)) {
        cancel(true);
    }
}