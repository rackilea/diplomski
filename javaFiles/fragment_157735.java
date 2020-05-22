public class AggregatingMessagesRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:start")
                .aggregate().constant(true)
                .completionTimeout(100L)
                .aggregationStrategy(new StringAggregationStrategy())
                .to("file:target/this_folder/result?allowNullBody=true");
    }

}