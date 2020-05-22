public class SplitBean {
    public Object init(Exchange exchange) {
        exchange.setProperty("splitTokens", new ArrayList<Integer>());
        return exchange.getIn().getBody();
    }

    public Object addToken(Exchange exchange) {
        ((List<Integer>)exchange.getProperty("splitTokens")).add(Integer.parseInt((String)exchange.getIn().getBody()));
        return null;
    }

    public Tuple done(Exchange exchange) {
        return new Tuple<String, List<Integer>>((String)exchange.getIn().getHeader("CamelFileName"), (List<Integer>)exchange.getProperty("splitTokens"));
    }
}