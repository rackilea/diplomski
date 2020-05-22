final String URI_FILE = "file:{{PATH}}";
final String POOLER = "&scheduler=quartz2&scheduler.cron=0+0/10+*+*+*+?";

from(URI_FILE + POOLER)
.pollEnrich().simple("{{URL_CHECKER}}",String.class).aggregationStrategy(new myEstratey())
.choice()
    .when(exchangeProperty("CONTINUE").isEqualTo(true))
        .log("Condition was met")
        .to(URI_DIRECT) //To another route
     .endChoice()
     .otherwise()
        .log("I'll try again later")
        .rollback() // rollback processing and keep file in original directory
.endChoice();