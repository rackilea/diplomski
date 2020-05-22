comp.whenComplete((result, e) -> {
    System.out.println("Got sample response");
    if (e != null) {
        context.response().setStatusCode(500)
                .end(e.getMessage());
    } else {
        context.response().setStatusCode(200)
                .putHeader("content-type", "text/html")
                .end(result);
    }
    System.out.println("end testCompBlocking....");
});