DesiredCapabilities cap = DesiredCapabilities.chrome();
ImmutableMap<String, String> commandLineArguments = ImmutableMap.<String, 
String>builder()
    .put("web-security", "false")
    .put("ssl-protocol", "any")
    .put("ignore-ssl-errors", "true")
    .put("webdriver-loglevel", "DEBUG")
    .put("ssl-client-certificate-file", certificatePath)
    .put("ssl-client-key-passphrase", certificatePassword)
    .build();
String[] params = commandLineArguments.entrySet().stream()
    .map(e -> String.format("--%s=%s", e.getKey(), e.getValue()))
    .collect(Collectors.toList())
    .toArray(new String[0]);
cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, params);
cap.setCapability(ChromeOptions.CAPABILITY, options);
WebDriver driver = new PhantomJSDriver(cap);
driver.get(Url);