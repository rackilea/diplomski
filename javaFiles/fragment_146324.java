for (Tuple t : l) {
    Stock s = (Stock) t.get(0);
    StockGroup sg = (StockGroup) t.get(1);

    System.out.println("Stock is : " + s + "    .... StockGroup: " + sg);
}