using(AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer"))
{
     using(AndroidJavaObject jo = jc.GetStatic<AndroidJavaObject>("currentActivity"))
     {
          jo.Call("Trigger", "my string");
     }
}