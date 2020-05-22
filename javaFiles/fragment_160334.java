Map<String, Object> deviceMetrics = new HashMap<>();
deviceMetrics.put("width", 1078);
deviceMetrics.put("height", 924);
deviceMetrics.put("pixelRatio", 3.0);
Map<String, Object> mobileEmulation = new HashMap<>();
mobileEmulation.put("deviceMetrics", deviceMetrics);
mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 8.0.0;" +
"Pixel 2 XL Build/OPD1.170816.004) AppleWebKit/537.36 (KHTML,
like Gecko) " +
"Chrome/67.0.3396.99 Mobile Safari/537.36");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
driver = new ChromeDriver(chromeOptions);