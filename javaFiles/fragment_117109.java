from("file:/tmp?include=.*.xml&doneFileName=${file:name}.done")
     .process(
    new Processor() {
         public void process(Exchange e) throws Exception{
        //Any logic or System.out.println("File is "+e.getIn().getBody());
         }
        });