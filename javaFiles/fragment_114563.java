/* INTERFACES FOR CALLBACK FUNCTIONAILITY */
public interface ShareStringCallback {
    public void onLoginComplete(String result);
}

public void Login(final ShareStringCallback callback)
{
    mainActivity.runOnUiThread(new Runnable() {

        @Override
        public void run() {
            try {
                Log.i(TAG,"Starting Authentication");

                try {
                    try {
                        Intent shareIntent = new Intent();
                        shareIntent.setAction(Intent.ACTION_SEND);
                        shareIntent.setClass(mainActivity,OnResultCallback.class);
                        OnResultCallback.shareStringCallback = callback;
                        mainActivity.startActivity(shareIntent);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        Log.i(TAG,"error sharing intent: " + e);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    Log.i(TAG,"Error getting Uri: " + e);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Log.i(TAG,"Error writing file: " + e);
            }
        }
    });
}