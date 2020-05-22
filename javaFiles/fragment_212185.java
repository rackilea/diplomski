from("restlet:"+BASE_URL+"seda?restletMethods=get").
routeId("SEDA async sender").
log(LoggingLevel.INFO, log.getName(), "SEDA test started").
log(LoggingLevel.INFO, log.getName(), "Transfer to SEDA...").
to("seda:test1?waitForTaskToComplete=Never");

from("seda:test1").
threads(4).
routeId("SEDA async receiver").
log(LoggingLevel.INFO, log.getName(), "SEDA active").
delay(4000).
log(LoggingLevel.INFO, log.getName(), "SEDA test complete");
//to("mock:update");