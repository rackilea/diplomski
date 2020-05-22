Currency usd = new Currency("USD");
Currency eur = new Currency("EUR");
usd.setExchangeRate(new ExchangeRate(eur, new BigDecimal("0.87540")));
eur.setExchangeRate(new ExchangeRate(usd, new BigDecimal("1.14233")));

BigDecimal myMoney = new BigDecimal("1000.00");
myMoney = usd.convert(eur, myMoney);
System.out.println("My Euros: " + myMoney);
myMoney = eur.convert(usd, myMoney);
System.out.println("My Dollars: " + myMoney);