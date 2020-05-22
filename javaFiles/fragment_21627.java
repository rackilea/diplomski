// previously "public String doInBackground()"
//  returned value handled through publishProgress.
@Override
public void run() {
    // recommended by Android Thread documentation
    android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

    // code previously in doInBackground