public void quitUnityActivity ()
{
    UnityPlayer.currentActivity.runOnUiThread(new Runnable(){
        public void run()
        {
            Log.v("Unity", "Unity Activity Exited!" );
            this.mUnityPlayer.quit();
            UnityPlayer.currentActivity.finish();
        }
    });
}