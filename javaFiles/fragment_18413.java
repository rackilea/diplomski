HttpGet get1 = new HttpGet("http://hosta/");
RequestConfig config1 = RequestConfig.custom().setSocketTimeout(10000).build();
get1.setConfig(config1);
HttpGet get2 = new HttpGet("http://hostb/");
RequestConfig config2 = RequestConfig.custom().setSocketTimeout(5000).build();
get2.setConfig(config2);