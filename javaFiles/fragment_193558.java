String responseStr = "{\"time\":{\"updated\":\"Sep 18, 2013 17:27:00 UTC\",\"updatedISO\":\"2013-09-18T17:27:00+00:00\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index. Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"bpi\":{\"code\":\"USD\",\"symbol\":\"$\",\"rate\":\"126.5235\",\"description\":\"United States Dollar\",\"rate_float\":126.5235}}";
    ObjectMapper mapper = new ObjectMapper();
    try {
        CoinDeskResponse coinDeskResponse = mapper.readValue(responseStr, CoinDeskResponse.class);

        System.out.println(coinDeskResponse.getTime().getUpdated());
        System.out.println(coinDeskResponse.getBpi().getDescription());
        System.out.println(coinDeskResponse.getBpi().getRateFloat());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }