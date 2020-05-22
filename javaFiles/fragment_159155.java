from(fromUri).process(new Processor() {
    public void process(Exchange msg)  {
        ... your processor impl
    }
})
.to("direct:yourOtherRoute")
.to("log:EndBatch"); 

from("direct:yourOtherRoute")
...