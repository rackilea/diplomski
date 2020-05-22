public void addBooking(RoutingContext ctx){
    save().setHandler(h -> {
        if(h.succeeded()){
            ctx.response().end(h.result());
        }else{
            ctx.response().setStatusCode(500).end(h.cause());
        }
    })
}