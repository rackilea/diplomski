public TradeInfo getStockInfoFromGoogle() throws InterruptedException, IOException{

    // do some web scraping
    return new TradeInfo(googleStockName, googleClosingPrice);

}