from("direct:DirectRoute")
    .routeId("DR")       
    .to("bean:processDirectQueueBean");

from("file:" + recoverableErrorsFolder +"?noop=true")
    .to("controlbus:route?routeId=DR&action=stop")
    .to("bean:processManualFilesDatabean")
    .to("controlbus:route?routeId=DR&action=start");