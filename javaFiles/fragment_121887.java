public void quitUnityActivity()
{
    Log.v("Unity", "Unity Activity Exited!");
    this.mUnityPlayer.quit();
    UnityPlayer.currentActivity.finish();
}