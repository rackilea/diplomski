String url = "http://www.amazon.com/dp/B00H2T37SO/?tag=stackoverfl08-20";
Document doc = Jsoup
                .connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36")
                .timeout(3000)
                .get();

Elements prices = doc.select("table.product b.priceLarge");
for (Element pr : prices)
{
    String priceWithCurrency = pr.text();
    System.out.println(priceWithCurrency);
    String priceAsText = priceWithCurrency.replaceAll( "[$,]", "" );
    double priceAsNumber = Double.parseDouble(priceAsText);
    System.out.println("Price: " + priceAsNumber);
}