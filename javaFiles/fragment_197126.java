-        server = ServerBuilder
+        server = NettyServerBuilder
                 .forPort(port)
+                .permitKeepAliveWithoutCalls(true)
+                .permitKeepAliveTime(5, TimeUnit.SECONDS)
                 .addService(this.queryService)
                 .addService(this.commandService)
                 .addService(this.subscriptionService)
                 .build();