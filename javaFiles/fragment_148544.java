JSONArray itemlines = new JSONArray();

Statement getLines = dbconnection.createStatement();
ResultSet LinesRS = getLines.executeQuery("SELECT 
b.line_number,b.ordered_item,b.description,b.line_quantity,
"(SELECT order_quantity_uom FROM oe_order_lines_all WHERE line_id = 
b.line_id) uom\n" +
"FROM rocell.xrcl_ns_int_quotation_details b WHERE b.header_id = 
"+getQuotationsRS.getString(1));
         while(LinesRS.next())
         { //every time this JSONObject items  is init and put into itemlines
           JSONObject items = new JSONObject();
           items.put("lineNo", LinesRS.getString(1));
           items.put("itemCode", LinesRS.getString(2));
           items.put("itemDesc", LinesRS.getString(3));
           items.put("qty", LinesRS.getString(4));
           items.put("unit", LinesRS.getString(22)); 
           itemlines.put(items);
         }



record.put("items", itemlines);