public class CustomProcessor {

    public void processDoIt(Exchange exchange) {
        DoIt smth = exchange.getIn().getBody(DoIt.class); //Your message's body              
    }

}