from("direct:start")
    .routeId("generateFileRoute")
    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
    .setHeader(Exchange.HTTP_URI, simple(URL))
    .setHeader("Authorization", simple(APP_KEY))
    .to(URL)
    .unmarshal(listJacksonDataFormat)
    .marshal(bindyCsvDataFormat)
    .to("sftp://FTP_HOST/DIR?username=???&password=??&fileName=RMA_OUT_${date:now:MMddyyyy_HHmmss}.csv");