for(String uri : sources){
    from(uri).to("direct:commonProcess");
}

from("direct:commonProcess")
    .routeId(Constants.ROUTE_ID)
    //...
    .log("Sending the request to all listeners")
    .to(this.destinations.toArray(new String[0]));