from("timer://foo?period="+serverData.getTimer())
  .threads(serverData.getNumberOfInstances())
  .setBody(constant(serverData.getSql()))
  .to("jdbc:" + serverData.getUrl() + serverData.getUserId())
  //Think about query parameters, based on first query result
  //You need to define them, by default the result is returned in the OUT body 
  //ArrayList<HashMap<String, Object>> in the OUT body
   .to("log:before-split?level=INFO&showAll=true&multiline=true")
   .split(body()) //because you received more then one record
   .to("log:after-split?level=INFO&showAll=true&multiline=true")
   .process(new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            //Record of first query after splitter in the Map
            Map<String, Object> record = exchange.getOut().getBody(Map.class);
            exchange.getIn().setHeader("numbersubscribers",  record.get("numbersubscribers"));
            exchange.getIn().setHeader("id",  record.get("id"));
        }
    })
   .to("log:before2query?level=INFO&showAll=true&multiline=true")
   .setBody(constant("insert into new_raw_table (numbersubscribers,values(:?numbersubscribers,:?id)"))

  .to("jdbc:".....) //You have to refer here to another datasource, maybe like below
 //jdbc:embeddedDataSource?allowNamedParameters=true&outputType=SelectOne&useHeadersAsParameters=true&resetAutoCommit=false
  .process(custom application logic);