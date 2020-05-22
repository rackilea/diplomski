...
 .setConfig(new JsonObject()
     .put("url", url)
     .put("timeout", Long.parseLong(ConfigurationUtil.CONFIG_SERVER_TIME_OUT))
     .put("httpClientConfiguration", new JsonObject()
         .put("trustAll", true) 
         .put("ssl", true)));
 ...