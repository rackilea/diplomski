final ExecutorService executor = Executors.newSingleThreadExecutor();
DefaultAccessLogReceiver.Builder builder = DefaultAccessLogReceiver.builder().setLogWriteExecutor(executor)
        .setOutputDirectory(Paths.get("/var/log/undertow"))
        .setLogBaseName("access-log.")
        .setLogNameSuffix("log")
        .setRotate(true);   

Undertow server = Undertow.builder()
    .addHttpListener(8080, "0.0.0.0")
    .setHandler(new AccessLogHandler(new MyHandler(), builder.build(),
            "combined", UndertowUrlRewrite.class.getClassLoader()))
    .build();

server.start();