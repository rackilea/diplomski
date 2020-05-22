MarketplaceBO marketplaceBOObject = new MarketplaceBO(entity.getMarketplaceID());
 try {
    marketplaceBOObject.loadFromSable();
 } catch (WhateverException e) {
    // Do something here, or, if you prefer, add the exception to a list and process later
    doSomething() ;
    // Continue your loop above
    continue ;
 }
 if (marketplaceBOObject.isActive()) {