public String saveListOfMarketPrice(MarketPrice marketPrice) {
    final Session session = getSession();
   Transaction tx = session.beginTransaction();

    for (Items item : marketPrice.marketPrices) {
       MarketPrice marketPriceToSaveInDBAsNewRow = new MarketPrice();
       marketPriceToSaveInDBAsNewRow.setAnalysisDate(new Date());
       marketPriceToSaveInDBAsNewRow.currentItem = item;
       marketPriceToSaveInDBAsNewRow.setItemName(marketPriceToSaveInDBAsNewRow.currentItem.getItemName());
       marketPriceToSaveInDBAsNewRow.setUnitofPrice(marketPriceToSaveInDBAsNewRow.currentItem.getUnitofPrice());
       marketPriceToSaveInDBAsNewRow.setMinimumPrice(marketPriceToSaveInDBAsNewRow.currentItem.getMinimumPrice());
       marketPriceToSaveInDBAsNewRow.setMaximumPrice(marketPriceToSaveInDBAsNewRow.currentItem.getMaximumPrice());
        session.save(marketPriceToSaveInDBAsNewRow);

        }
     tx.commit();
     session.close();
     //session.getTransaction().commit();
     return "success";
}