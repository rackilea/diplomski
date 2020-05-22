context.vertx().<String>executeBlocking(future -> {
            String result = "Not Success";
            try {
                result = comp.get();
            } catch (Exception e) {
                System.out.println("Exception in getting from Completable..." + e.getMessage());
                e.printStackTrace();
            }
            future.complete(result);
        },
        false,
        result -> {
            context.response().setStatusCode(200);
            context.response().putHeader("content-type", "text/html");
            context.response().end(result.result());
            System.out.println("end testCompBlocking....");
        });