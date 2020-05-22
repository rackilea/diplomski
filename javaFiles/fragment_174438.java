BindyCsvDataFormat bindy = new BindyCsvDataFormat(PurchaseOrder.class);
bindy.setLocale(Locale.US.getCountry());

from("direct:toCsv")
    .marshal(bindy)
    ...