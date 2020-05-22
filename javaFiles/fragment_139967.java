javax.xml.ws.Service service = Service.create(
     new URL("http://example.org/stocks.wsdl"),
     new QName("http://example.org/stocks", "StockQuoteService"));
 com.example.StockQuoteProvider proxy = service.getPort(portName,
 com.example.StockQuoteProvider.class)
 javax.xml.ws.BindingProvider bp = (javax.xml.ws.BindingProvider)proxy;
 Map<String,Object> context = bp.getRequestContext();
 context.setProperty("javax.xml.ws.session.maintain", Boolean.TRUE);
 proxy.getLastTradePrice("ACME");