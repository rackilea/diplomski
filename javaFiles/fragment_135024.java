public class MyRemoteWebDriver extends RemoteWebDriver {
....
@Override
protected void startSession(Capabilities desiredCapabilities, Capabilities requiredCapabilities) {
    String sid = loadSessionID("SID_NAME");
    if (sid != null) {
        super.startSession(desiredCapabilities, requiredCapabilities);
        log.info("Old SID: " + sid);
        setSessionId(sid);
        try {
            getCurrentUrl();
            log.info("Old url: " + getCurrentUrl());
        } catch (WebDriverException e) {
            sid = null;
        }
    }
    if (sid == null) {
        super.startSession(desiredCapabilities, requiredCapabilities);
        saveSessionID(getSessionId().toString());
        log.info("New SID: " + getSessionId().toString());
    }
  }
}