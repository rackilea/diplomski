public void flatMap1(Trade trd, Collector<Tuple2<Trade, MarketData>> out) throws Exception {

    trades.update(trd);;
    MarketData mktData = marketData.value();
    out.collect(new Tuple2<Trade, MarketData>(trd, mktData));
}