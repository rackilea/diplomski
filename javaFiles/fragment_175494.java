public JAXBElement<IBMarketInfo>getMarketData(JAXBElement<IBMarketInfo> info){

    MainAccess ma = new MainAccess(); // MainAccess Will pull the data from external server
    IBMarketInfo market = info.getValue(); 

   ma.onRequestData(market.getTickerId(),market.getContract(),market.getGenericTickList(),
   market.getSnapShot()); // set the user given input from xml 

  return info;
}