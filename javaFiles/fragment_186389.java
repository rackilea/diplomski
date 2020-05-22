Map<Integer, UDTValue> ols = row.getMap("o_ols", Integer.class, UDTValue.class);
for (Integer key: ols.keySet()) {
     UDTValue ol = ols.get(key);
     olIId = ol.getInt("ol_i_id");
     olQuantity = ol.getInt("ol_quantity");
     olDistInfo = ol.getString("ol_dist_info");
     olSupplyWId = ol.getInt("ol_supply_w_id");
     olAmount = ol.getFloat("ol_amount");
     olSum += olAmount;
     newOrderLine = orderLineType.newValue()
         .setInt("OL_I_ID", olIId)
         .setTimestamp("ol_delivery_d", new Timestamp(now.getTime()))
         .setFloat("ol_amount", olAmount)
         .setInt("ol_supply_w_id", olSupplyWId)
         .setInt("ol_quantity", olQuantity)
         .setString("ol_dist_info", olDistInfo);
     orderLines.put(key, newOrderLine);
 }