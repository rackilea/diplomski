StringBuilder sb = new StringBuilder("Exception encountered when quiting driver: ");
 WebUXDriver w = WebUIDriver.getWebUXDriver();
 Config c = w.getConfig();
 Browser b = c.getBrowser();
 sb.append(b.name());
 sb.append(":");
 sb.append(ex.getMessage());
 String line = sb.toString();
 TestLogging.log(line);