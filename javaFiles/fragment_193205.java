router.route("/hello").handler(rc -> {
    rc.response().setChunked(true).putHeader("Content-Type", "text/plain");
    final long timer = vertx.setPeriodic(1000, l -> {
        try {
            System.out.println("hello");
            rc.response().write("hello\n");
        } catch (Exception e) {
            e.printStackTrace();
            rc.response().close();
        }
    });

    // Handle close event to cancel the timer
    rc.response().closeHandler(evt -> {
        System.out.println("Stopping");
        vertx.cancelTimer(timer);
    });
});