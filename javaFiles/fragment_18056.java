private static List<Double> generateTotalPriceList(List<Double> prices, List<Integer> quantities) {
    List<Double> totalPriceList = null;
    if (prices != null && prices.size() > 0
            && quantities != null && quantities.size() > 0) {
        if (prices.size() == quantities.size()) {
            totalPriceList = new ArrayList<Double>();
            double totalValue;
            for (int i = 0; i < prices.size(); i++) {
                totalValue = prices.get(i) * (double) quantities.get(i);
                totalPriceList.add(totalValue);
            }
        }
    }
    return totalPriceList;
}