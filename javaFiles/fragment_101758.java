Map<String,Map<String,StockReOrderLevel>> stockReorderLevels = new HashMap<>();


outletList.forEach(outletCode->{

List<StockReOrderLevel> defaultStockItemList = db.findDefaultStockItem();
List<String> orderedItemCodes=new ArrayList<>();
Map<String, StockReOrderLevel> itemMap = new HashMap<>();

defaultStockItemList.forEach(item-> {
    orderedItemCodes.add(item.getCode());
    itemMap.put(item.getCode(), item);
});

    Map<String, StockReOrderLevel> clone = (Map<String, StockReOrderLevel>) ((HashMap<String, StockReOrderLevel>) itemMap).clone();
    List<OutletItem> lastStockTakenForOutlet = db.findLastStockTakenForOutlet(outletCode);

    if(lastStockTakenForOutlet!=null && !lastStockTakenForOutlet.isEmpty()){
        lastStockTakenForOutlet.forEach(outletItem -> {

            if (clone.containsKey(outletItem.getItemCode())) {
                StockReOrderLevel stockReOrderLevel = clone.get(outletItem.getItemCode());
                stockReOrderLevel.setReorderlevel(outletItem.getReorderLevel());
                clone.put(outletItem.getItemCode(),stockReOrderLevel);
            }
        });

        //get database values
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("outletCode",outletCode);
        paramMap.put("takenDate",lastStockTakenForOutlet.get(0).getTakenDate());
        List<ItemLevel> reOrderedLevelOutletItems=db.findTotalOrderdBottlesByOutlet(paramMap);

        //change the clone again
        if(reOrderedLevelOutletItems!=null && !reOrderedLevelOutletItems.isEmpty()){
            reOrderedLevelOutletItems.forEach(itemLevel -> {

                if (clone.containsKey(itemLevel.getItemCode())) {

                    StockReOrderLevel stockReOrderLevel = clone.get(itemLevel.getItemCode());
                    stockReOrderLevel.setReorderlevel(stockReOrderLevel.getReorderlevel()+itemLevel.getAmount());

                    clone.put(itemLevel.getItemCode(),stockReOrderLevel);
                }
            });
        }
    }

    //convert map and it gives the map correctly
    Map<String,StockReOrderLevel> idlOrdered= getIndexedItemOrder(orderedItemCodes,clone);

    //i printed values before add to parent map in here
    stockReorderLevels.put(outletCode, idlOrdered);
});
return stockReorderLevels;