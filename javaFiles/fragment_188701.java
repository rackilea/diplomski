class StaticExample
{
     private static String loginURL;

     //isConnectedToServer must be declared static in order for this to work!
     //I believe your current function can be made static without changing its code
     public static boolean isConnectedToServer()
     {
        ...
     }

     static
     {
           if(isConnectedToServer("192.168.1.5", 500))
           {
                loginURL = "http://192.168.1.5/android_login_api/";
           }
           //you might want to use else if here
           if(isConnectedToServer("192.168.1.9", 500))
           {
                loginURL = "http://192.168.1.9/android_login_api/";
           }
           //if neither if starement executes, loginURL is null.
     }