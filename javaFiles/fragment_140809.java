this.closingPrice.bind(Bindings.createDoubleBinding(() -> 
    priceService.getLastValue().getPrice(),
    priceService.lastValueProperty());
this.stockName.bind(Bindings.createStringBinding(() ->
    priceService.getLastValue().getName(),
    priceService.lastValueProperty());