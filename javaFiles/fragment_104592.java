public HashMap<String, Object> prepareCustomer(Customer customer) {
  HashMap<String, Object> responseMap = new HashMap<String, Object>();

  responseMap.put("scrapCost", customer.getScrapCost());
  responseMap.put("salePrice", customer.getSalePrice());
  responseMap.put("minCastingWt", customer.getMinCastingWt());

  return responseMap;
}