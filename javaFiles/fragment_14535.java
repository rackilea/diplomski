//...
String url;
switch( System.getProperty("os.name") ) {
    case "Windows 8.1":
    case "Windows Vista":
    //etc for all windows systems
    {
      url = "C:/Users/user_name/downloads..."
      break;
    }
    case "Mac OS X": //...
    case "SunOS": //...
    case "Linux": //...
    //etc all systems you want to support
}