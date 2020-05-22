Map<String, Integer> prices = new TreeMap<String, Integer>(); // sorted map/keys in sorted order

try {
    Document doc = Jsoup
                .connect("https://bestprice-live-backend.mcon.net/flights-by-day?l=fr_fr&departure=PAR&destination=BER&departureFrom=2016-09-01&departureTo=2016-09-30&cabin=Economy&duration=7")
                .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
                .referrer("http://www.lufthansa.com/vol/vol-paris-berlin")
                .get();

    JSONObject obj = (JSONObject) new JSONParser().parse(doc.text());

    obj = (JSONObject) obj.get("dates");

    for (Iterator<?> iterator = obj.keySet().iterator(); iterator.hasNext();) {
        String key = (String) iterator.next();
        JSONObject dateObject = (JSONObject) obj.get(key);
        Double price = (Double) dateObject.get("price");
        int roundedPrice = (int) Math.ceil(price); // lufthansa displays prices rounded up
        prices.put(key, roundedPrice);
    }

    for (String key : prices.keySet()) {
        System.out.println(key + ": " + prices.get(key) + " €");
    }
} catch (IOException e) {
    e.printStackTrace();
} catch (ParseException e) {
    e.printStackTrace();
}