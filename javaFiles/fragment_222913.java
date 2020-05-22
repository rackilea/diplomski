FirefoxBinary binary = new FirefoxBinary();  
 File firefoxProfileFolder = new 
 File("/Users/xxx/work/xxx/selenium/src/test/resources/firefoxprofile");
 FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
 profile.setAcceptUntrustedCertificates(true);
 webDriver = new FirefoxDriver(binary, profile);