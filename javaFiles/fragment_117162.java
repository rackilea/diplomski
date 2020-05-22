for(int i = 1; i < 67; i++) {
    String link = "http://www.myhome.ie/rentals/dublin/property-to-rent?page=" + i;
    Document doc2 = Jsoup.connect(link).get();
    Elements addresses = doc2.select("#results #resultItem .address a");
    Elements prices = doc2.select("#results #resultItem .descriptionTitle .price");

    //assumes a 1-to-1 address-price mapping
    for(int j = 0; j < addresses.size(); j++) {
        System.out.println(addresses.get(j).text());
        System.out.println(prices.get(j).text());
    }
}