public class UserIDProcessor implements Processor{
    public void process(Exchange exchange) throws Exception {
        String input = exchange.getIn().getBody(String.class);
        if (input.split(" - ").length > 2){
            exchange.getIn().setHeader("LOGLEVEL", input.split(" - ")[1]);
            exchange.getIn().setHeader("USERID", input.split(" - ")[2]);
        }
        exchange.getIn().setBody(input);
    }
}