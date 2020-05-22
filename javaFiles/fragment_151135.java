service = AppiumDriverLocalService.buildService( new
      AppiumServiceBuilder().usingDriverExecutable(new File(
      "C:\\Program Files\\nodejs\\node.exe")) .withAppiumJS(new File(
      "C:\Users\YourUserName\AppData\Roaming\npm\node_modules\appium\build\lib\main.js"
      )) .withIPAddress("127.0.0.1").usingAnyFreePort());

     service.start();