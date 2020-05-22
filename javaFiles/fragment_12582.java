@Override
public boolean promptPassword(String s) {

    synchronized (someObject) {
        // Notify GUI thread about password prompt
        publishProgress();

        // wait for password prompt to be submitted
        wait();
    }

    return false;
}

@Override
public void onProgressUpdate (Progress... values)
{
     // Do password prompt here

     // And tell background thread, that we have a password already
     synchronized (someObject) {
         notify();
     }
}