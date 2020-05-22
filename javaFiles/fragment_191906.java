int resIDOfImageToLoad =  0;

public static void SetImageToLoad(String imageName)
{
    if(imageName.equals("abc"))
    {
        resIDOfImageToLoad = R.id.abc;
    }
    else if(imageName.equals("xyz"))
    {
        resIDOfImageToLoad = R.id.xyz;
    }
 }

 public static int GetResourceIDOfImageToLoad()
 {
     return resIDOfImageToLoad;
 }