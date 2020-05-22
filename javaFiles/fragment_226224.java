private Double initialPrice = null;
private double instancePrice;
...
@Scheduled(fixedRate = (5))
private double getInstancePrice(){
    try {
        instancePrice = Double.parseDouble(String.valueOf(api.pricesMap().get("BTCUSDT")));
        if (initialPrice == null) {
            initialPrice = instancePrice;
        } else if (instancePrice > initialPrice) {
            // do this
        }
    } catch (BinanceApiException e) {
        e.printStackTrace();
    }
    return instancePrice;
}