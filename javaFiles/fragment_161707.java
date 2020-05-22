{
  "capabilities":
      [
        {
          "browserName": "firefox",
          "version": "39.0",
          "firefox_binary": "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe",
          "maxInstances": 5,
          "seleniumProtocol": "WebDriver"
        },
        {
          "browserName": "chrome",
          "version": "54.0",
          "maxInstances": 5,
          "seleniumProtocol": "WebDriver"
        },
        {
          "browserName": "internet explorer",
          "version": "11",
          "maxInstances": 1,
          "seleniumProtocol": "WebDriver"
        }
      ],
  "configuration":
  {
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "role": "node",
    "host": "127.0.0.1",
    "port": 5555,

    "maxSession": 5,
    "cleanUpCycle":2000,
    "registerCycle": 10000,
    "nodeTimeout":120,
    "nodePolling":2000,

    "register": true,
    "hubPort": 4444,
    "hubHost": "127.0.0.1"
  }
}