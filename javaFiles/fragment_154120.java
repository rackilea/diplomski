ThrottlingInflightRoutePolicy trp = new ThrottlingInflightRoutePolicy();
    trp.setMaxInflightExchanges(50);

    SuspendOtherRoutePolicy sorp = new SuspendOtherRoutePolicy("lowPriority");

    from("file://cameldest/queue/low?delay=500&maxMessagesPerPoll=25&preMove=inprogress&delete=true")
    .routeId("lowPriority")
    .log("Copying over to high priority: ${in.headers."+Exchange.FILE_PATH+"}")
    .to("file://cameldest/queue/high");

    from("file://cameldest/queue/high?delay=500&maxMessagesPerPoll=25&preMove=inprogress&delete=true")
    .routeId("highPriority")
    .routePolicy(trp)
    .routePolicy(sorp)
    .threads(20)
    .log("Before: ${in.headers."+Exchange.FILE_PATH+"}")
    .delay(2000) // This is where business logic would happen
    .log("After: ${in.headers."+Exchange.FILE_PATH+"}")
    .stop();