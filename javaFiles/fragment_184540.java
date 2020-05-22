AndroidJavaClass unityClass;
AndroidJavaObject unityActivity;
AndroidJavaObject unityContext;
AndroidJavaClass customClass;

void Start()
{
    //Replace with your full package name
    sendActivityReference("fr.vincentmazet.utilslibrary.FlashLight");

    //Enable Flashlight
    enableFlash();

   //Disable Flashlight
   //stopFlash();
}

void sendActivityReference(string packageName)
{
    unityClass = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
    unityActivity = unityClass.GetStatic<AndroidJavaObject>("currentActivity");
    unityContext = unityActivity.Call<AndroidJavaObject>("getApplicationContext");

    customClass = new AndroidJavaClass(packageName);
    customClass.CallStatic("receiveContextInstance", unityContext);
}

bool enableFlash()
{
   return customClass.CallStatic<bool>("enableFlash");
}

bool stopFlash()
{
   return customClass.CallStatic<bool>("stopFlash");
}