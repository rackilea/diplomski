String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
Map<String, Stock> stocks = YahooFinance.get(symbols); 

for(Stock s : stocks.values()) {
    System.out.println(s.getName() + ": " + s.getQuote().getPrice());
}