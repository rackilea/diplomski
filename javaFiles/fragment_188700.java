class Example
{
     private String loginURL; //non-static, no initialization

     public Example()//construcutor
     {
           //run conditions normally
           if(this.isConnectedToServer("192.168.1.5", 500))
           {
                loginURL = "http://192.168.1.5/android_login_api/";
           }
           //you might want to use else if here
           if(this.isConnectedToServer("192.168.1.9", 500))
           {
                loginURL = "http://192.168.1.9/android_login_api/";
           }
           //if neither if starement executes, loginURL is null.
     }
}